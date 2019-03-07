package org.jackzeng.graphx

import org.apache.spark.graphx.{Graph, GraphLoader}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author xijin.zeng created on 2019/3/7
  */
object Test {

  var conf: SparkConf = null
  var sc: SparkContext = null

  def setup(): Unit = {
    conf = new SparkConf()
      .setAppName("graphx-test")
      .setMaster("local[*]")

    sc = SparkContext.getOrCreate(conf)
  }

  def buildGraphFromFiles(vertexFile: String, edgeFile: String): Graph[Array[String], Int] = {
    val vertexIdProperties: RDD[(Long, Array[String])] = sc.textFile(vertexFile)
      .map(line => line.split(","))               // 解析行数据
      .map(list => (list.head.toLong, list.tail)) // 转为属性节点RDD[(vid, attr)]，作为构建GraphX的VertexRDD

    val edgesBuildGraph = GraphLoader.edgeListFile(sc, edgeFile)

    val graph: Graph[Array[String], Int] = edgesBuildGraph.outerJoinVertices(vertexIdProperties) {
      case (id, dst, Some(attrList)) => attrList
      case (id, dst, None) => Array.empty[String] // 无属性的节点
    }

    graph // return the graph
  }


  def main(args: Array[String]): Unit = {
    setup()

    val graph: Graph[Array[String], Int] = buildGraphFromFiles("data/graphx/vertex-id-pros.txt", "data/graphx/edges-list.txt")
    println("vertex count: " + graph.vertices.count())
    println("relation count: " + graph.edges.count())
  }

}
