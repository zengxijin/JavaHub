package org.jackzeng

import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.graphx.{Edge, Graph, VertexId}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.junit.{After, Before, Test}
import org.neo4j.driver.internal.{InternalNode, InternalRelationship}
import org.neo4j.spark.{Executor, Neo4j, Neo4jDataFrame, Neo4jGraph}

import scala.collection.JavaConverters._
/**
  * @author xijin.zeng created on 2018/4/27
  */
class Neo4jRemoteTest {

  private var conf: SparkConf = null
  private var sc: JavaSparkContext = null

  @Before
  @throws[Exception]
  def setup(): Unit = {
    val remoteServerBoltUri = "bolt://192.168.56.101"
    val user = "neo4j"
    val password = "zengxijin123"

    conf = new SparkConf().setAppName("remoteNeoTest").setMaster("local[*]")
      .set("spark.driver.allowMultipleContexts", "true")
      .set("spark.neo4j.bolt.url", remoteServerBoltUri)
      .set("spark.neo4j.bolt.user","neo4j")
      .set("spark.neo4j.bolt.password","zengxijin123")
      //need to set the memory avoid to running error in localhost
      .set("spark.testing.memory", "2147480000")



    sc = SparkContext.getOrCreate(conf)
  }

  @After
  def tearDown(): Unit = {
    sc.close
  }

  @Test
  def testCypherQuery(): Unit = {
    val neo4j: Neo4j = Neo4j(sc).cypher("MATCH (n)-[r]-(m) return n,r,m LIMIT 10")
    neo4j.loadNodeRdds.foreach(
      //row : sql.Row includes InternalNode and InternalRelationship
      row => {
        println(row)
        val entities = row.toSeq
        entities.foreach(
          item => {
            if (item.isInstanceOf[InternalNode]) {
              println(item.asInstanceOf[InternalNode].asValue())
            }

            if (item.isInstanceOf[InternalRelationship]) {
              println(item.asInstanceOf[InternalRelationship].asValue())
            }
          }
        )

      }
    )
  }

  @Test
  def testCypherInsert(): Unit ={
    //you can create the relationship chain in one cypher
    val cypherInsert = "CREATE (:Worker { name:'Andres' })-[:WORKS_AT]->(:Factory {name:'IBM'})<-[:WORKS_AT]-(:Worker { name: 'Michael' })"
    //query: MATCH (:Worker)-[]-(:Worker)
    //val neo4j: Neo4j = Neo4j(sc)
    Executor.execute(sc.sc, cypherInsert, Map(("","")))

    //has no effect on graph
    //Neo4j(sc).cypher(cypherInsert)
  }

  @Test
  def testLoadAndModify(): Unit ={
    val cypherQuery = "MATCH (n:Worker) where n.name='Andres' return n"
    val neo4j: Neo4j = Neo4j(sc).cypher(cypherQuery)

    printNodeRddInfo(neo4j.loadNodeRdds)

    //multiple properties in GraphX vertex can't save to Neo4j
//    val nodes: RDD[(VertexId, (String, String, Long))] = sc.makeRDD(Seq((1L, ("A", "B", 10L)), (2L, ("C", "D", 20L))))
//    val edges: RDD[Edge[String]] = sc.makeRDD(Seq(Edge(1L, 2L, "ABC")))
//    val graph = Graph[(String, String, Long), (String)](nodes, edges)

    val nodes: RDD[(VertexId, String)] = sc.makeRDD(Seq((1L, "A"), (2L, "B"))) //节点: (vid, attr)
    val edges: RDD[Edge[String]] = sc.makeRDD(Seq(Edge(1L, 2L, "ABC"))) //边:(srcVid, dstVid, attr)
    val graph = Graph[(String), (String)](nodes, edges) //构建GraphX图（泛型参数里都是属性的指定）

    //Neo4jGraph.saveGraph(sc, graph, "prop")
    Neo4jGraph.saveGraph(
      sc,
      graph, //GraphX 生成的图
      "vpro", //指定到neo4j的属性名称，对应取的值就是Vertex上attr的值
      ("FOOBAR", "epro"), //指定到neo4j上边的label和对应的属性名称，对应属性取的值也是Edge里面的attr的值
      Option("Foo", "vid"), //起始节点，第一个参数Foo在Neo4j上就是节点的label，第2个参数vid在neo4j上对应就是属性名称，属性的值是Vertex的vid的值，一定是Long型的
      Option("Foo", "vid"), //结束节点，参考起始节点
      merge = true)
  }

  @Test
  def mergeEdgeList(): Unit = {
    val rows = sc.makeRDD(Seq(Row("Keanu", "Matrix")))
    val schema = StructType(
      Seq(
        StructField("name", DataTypes.StringType),
        StructField("title", DataTypes.StringType)
      )
    )
    val df = new SQLContext(sc).createDataFrame(rows, schema)
    Neo4jDataFrame.mergeEdgeList(
      sc,
      df,
      ("Person",Seq("name")),
      ("ACTED_IN",Seq.empty),
      ("Movie",Seq("title"))
    )
  }

  @Test
  def mergeEdgeListMultiplePros(): Unit = {
    val rows = sc.makeRDD(Seq(Row("Apro1", "Apro2", "Apro3", 1L), Row("Bpro1", "Bpro2", "Bpro3", 2L)))

    val schema = StructType(
      Seq(
        StructField("p1", DataTypes.StringType),
        StructField("p2", DataTypes.StringType),
        StructField("p3", DataTypes.StringType),
        StructField("p4", DataTypes.LongType)
      )
    )

    //Neo4jDataFrame.mergeEdgeList可以通过spark SQL生成的数据结构，来插入到数据库中，但是只能支持一个label的设置
    val df = new SQLContext(sc).createDataFrame(rows, schema)
    Neo4jDataFrame.mergeEdgeList(
      sc,
      df,
      ("TypeA", Seq("p1", "p2")), //开始节点，p1和p2结果都会是label为TypeA的属性
      ("XREL", Seq.empty), //关系，Seq.empty表示没有属性的关系
      ("TypeB", Seq("p3", "p4")) //结束节点，p1和p2结果都会是label为TypeA的属性
    )

  }

  @Test
  def mergeEdgeListWithRelPros(): Unit = {
    val seqs = Seq(
      Row("Row1Val1", "Row1Val2", "Row1Val3", "RelPro", 123, 0.55D),
      Row("Row2Val1", "Row2Val2", "Row2Val3", "RelPro", 456, 0.88D)
    )

    val rdds = sc.makeRDD(seqs)
    /**
      * 这里的schema的设计比较重要
      * column的名字直接对应节点或者关系的properties，因此最好的设计应该提前设计好节点和关系的模型，然后生成对应的schema
      * 最后使用mergeEdgeList(sparkContext,dataFrame,srcNode,relPro,dstNode) 来插入到图中
      */
    val schema = StructType(
      Seq(
        StructField("COL_1", DataTypes.StringType),
        StructField("COL_2", DataTypes.StringType),
        StructField("COL_3", DataTypes.StringType),
        StructField("COL_4", DataTypes.StringType),
        StructField("COL_5", DataTypes.IntegerType),
        StructField("COL_6", DataTypes.DoubleType)
      )
    )

    val dataFrame = new SQLContext(sc).createDataFrame(rdds, schema)
    Neo4jDataFrame.mergeEdgeList(
      sc,
      dataFrame,
      ("StartNodeLabel", Seq("COL_1", "COL_2")),
      ("RelLabel", Seq("COL_4")), //关系的属性也从dataframe中取值填充
      ("EndNodeLabel", Seq("COL_3", "COL_5", "COL_6"))
    )

  }


  def printNodeRddInfo(nodeRdd: RDD[Row]): Unit = {
    nodeRdd.foreach(
      row => {
        row.toSeq.foreach(x => {
          val node = x.asInstanceOf[InternalNode]
          println(node.asMap())
        })
      }
    )
  }


}
