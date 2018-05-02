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
    val remoteServerBoltUri = "bolt://10.132.0.5"
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

    val nodes: RDD[(VertexId, String)] = sc.makeRDD(Seq((1L, "A"), (2L, "B")))
    val edges: RDD[Edge[String]] = sc.makeRDD(Seq(Edge(1L, 2L, "ABC")))
    val graph = Graph[(String), (String)](nodes, edges)

    //Neo4jGraph.saveGraph(sc, graph, "prop")
    Neo4jGraph.saveGraph(sc, graph, "vpro", ("FOOBAR", "epro"), Option("Foo", "vid"), Option("Foo", "vid"), merge = true)
  }

  @Test
  def mergeEdgeList(): Unit = {
    val rows = sc.makeRDD(Seq(Row("Keanu", "Matrix")))
    val schema = StructType(Seq(StructField("name", DataTypes.StringType), StructField("title", DataTypes.StringType)))
    val df = new SQLContext(sc).createDataFrame(rows, schema)
    Neo4jDataFrame.mergeEdgeList(sc, df, ("Person",Seq("name")),("ACTED_IN",Seq.empty),("Movie",Seq("title")))
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
      ("TypeA", Seq("p1", "p2")),
      ("XREL", Seq.empty),
      ("TypeB", Seq("p3", "p4"))
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
