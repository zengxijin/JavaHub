package org.jackzeng

import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.{SparkConf, SparkContext}
import org.junit.{After, Before, Test}
import org.neo4j.driver.internal.InternalNode
import org.neo4j.harness.{ServerControls, TestServerBuilders}
import org.neo4j.spark.{Executor, Neo4j}

import scala.collection.JavaConverters._


/**
  * @author xijin.zeng created on 2018/4/26
  */
class Neo4jSparkTest {
  val FIXTURE: String = "CREATE (:A {a:0})-[:REL {foo:'bar'}]->(:B {b:1})"
  private var conf: SparkConf = null
  private var sc: JavaSparkContext = null
  private var server: ServerControls = null

  @Before
  @throws[Exception]
  def setUp {
    //setup neo4j local server and insert Nodes and Relationship
    server = TestServerBuilders.newInProcessBuilder.withConfig("dbms.security.auth_enabled", "false").withFixture(FIXTURE).newServer

    conf = new SparkConf().setAppName("neoTest").setMaster("local[*]")
      .set("spark.driver.allowMultipleContexts", "true")
      .set("spark.neo4j.bolt.url", server.boltURI.toString)
      //need to set the memory avoid to running error in localhost
      .set("spark.testing.memory", "2147480000")

    sc = SparkContext.getOrCreate(conf)
  }

  @After
  def tearDown {
    server.close
    sc.close
  }

  @Test
  def runCypherQueryWithParams {
    val data = List(Map("age"->1,"name"->"Calvin").asJava, Map("age"->2,"name"->"Xijin").asJava ).asJava

    Executor.execute(sc.sc, "UNWIND {data} as row CREATE (n:Test {age:row.age}) SET n.name = row.name", Map(("data",data)))

    val neo4j: Neo4j = Neo4j(sc).cypher("MATCH (n:Test) WHERE n.age <= {age} RETURN n").param("age", 10)
    neo4j.loadNodeRdds.foreach(
      //row : sql.Row
      row => {
        val nodes = row.toSeq.map(item => item.asInstanceOf[InternalNode])
        println("size=" + nodes.size)

        nodes.foreach(
          node => {

            //id : Long
            println(node.id())

            //labels : ArrayList
            for (x <- node.labels().asScala) {
              println(x)
            }

            //properties : HashMap
            for ((k,v) <- node.asMap().asScala) {
              println(k + " = " + v)
            }

          }
        )

      }
    )


  }





}
