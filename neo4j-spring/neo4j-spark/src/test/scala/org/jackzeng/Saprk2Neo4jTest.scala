package org.jackzeng

import org.apache.spark.SparkContext
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.graphx.{Edge, Graph, VertexId}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.neo4j.spark.{Neo4jDataFrame, Neo4jGraph}

/**
  * @author xijin.zeng created on 2018/9/7
  */
object Saprk2Neo4jTest {
  val remoteUrl = "bolt://192.168.56.101"
  val user = "neo4j"
  val password = "password123"

  def main(args: Array[String]): Unit = {
    val sc: JavaSparkContext = SparkContext.getOrCreate(NeoSparkConf.getLocalConf(remoteUrl, user, password, "testApp"))
    //    testGraphX2Neo4j(sc)
    //    mergeEdgeList(sc)
    dataFrame2Neo4j(sc)
    sc.close()
  }

  /**
    * Neo4jGraph.saveGraph 接口真的太烂了，只能支持节点1个属性的操作，也就是第3个参数是String
    * 而且这里的映射从GraphX转为Neo4j的时候，对应Vertex的vid也会映射为对应的其中的一个属性
    * @param sc
    */
  def testGraphX2Neo4j(sc: JavaSparkContext): Unit = {
    val nodes: RDD[(VertexId, String)] = sc.makeRDD(Seq((1L, "A"), (2L, "B"))) //节点: (vid, attr)
    val edges: RDD[Edge[String]] = sc.makeRDD(Seq(Edge(1L, 2L, "ABC"))) //边:(srcVid, dstVid, attr)
    val graph = Graph[(String), (String)](nodes, edges) //构建GraphX图（泛型参数里都是属性的指定）

    Neo4jGraph.saveGraph(
      sc,
      graph, //GraphX 生成的图
      "node_pro_name", //指定到neo4j的属性名称，对应取的值就是Vertex上attr的值
      ("REL_type", "REL_pro_name"), //指定到neo4j上边的label和对应的属性名称，对应属性取的值也是Edge里面的attr的值
      Option("Node_type", "node_pro_vid"), //起始节点，第一个参数Foo在Neo4j上就是节点的label，第2个参数vid在neo4j上对应就是属性名称，属性的值是Vertex的vid的值，一定是Long型的
      Option("Node_type", "node_pro_vid"), //结束节点，参考起始节点
      merge = true)

  }

  /**
    * 如果你要支持多个参数属性的操作，需要使用这个将DataFrame映射为对应的属性pro的接口
    * 也就是Neo4jDataFrame.mergeEdgeList的接口
    * 在实际使用的时候建议使用这个将DataFrame与Neo4j互操作
    * @param sc
    */
  def mergeEdgeList(sc: JavaSparkContext): Unit = {
    /**
      * 构建DataFrame
      */
    val rows = sc.makeRDD(Seq(Row("Keanu", "Matrix")))
    val schema = StructType(
      Seq(
        StructField("name", DataTypes.StringType), //这里的Field一会会被提取为对应的节点或者边的属性
        StructField("title", DataTypes.StringType)
      )
    )
    val df = new SQLContext(sc).createDataFrame(rows, schema)

    /**
      * 将DataFrame转存为对应的Neo4j的数据
      */
    Neo4jDataFrame.mergeEdgeList(
      sc,
      df,
      ("Person",Seq("name")),
      ("ACTED_IN",Seq.empty),
      ("Movie",Seq("title"))
    )
  }

  def dataFrame2Neo4j(sc: JavaSparkContext): Unit = {
    val rows = sc.makeRDD(
      Seq(
        Row("p1", "p2", 100L, "r1"),
        Row("p3", "p4", 200L, "r2")
      ))
    val schema = StructType(
      Seq(
        StructField("C1", DataTypes.StringType),
        StructField("C2", DataTypes.StringType),
        StructField("C3", DataTypes.LongType), //LongType会失败？
        StructField("C4", DataTypes.StringType)
      )
    )
    val sqlContext = new SQLContext(sc)
    val df = sqlContext.createDataFrame(rows, schema)
    //创建一个临时表或者视图，供后面sparkSQL操作
    df.createOrReplaceTempView("tmp")
    df.show()

    val sqlDF = sqlContext.sql("select C1, C2 from tmp")
    sqlDF.show()

    Neo4jDataFrame.mergeEdgeList(
      sc,
      df,
      ("NodeTypeOne", Seq("C1","C2","C3")),
      ("EdgeType", Seq("C4")),
      ("NodeTypeTwo", Seq("C1","C2","C3"))
    )
  }
}
