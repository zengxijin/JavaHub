package org.jackzeng

import org.apache.spark.api.java.JavaSparkContext
import org.neo4j.spark.Executor.CypherResult
import org.neo4j.spark.{Executor, Neo4j}

/**
  * Neo4jExecutor is the wrapper for Neo4j Spark CURD api
  * @author xijin.zeng created on 2018/6/4
  */
class Neo4jExecutor(context: JavaSparkContext) {

  /**
    * read only query api
    * @param cypher
    * @return Neo4j
    */
  def query(cypher: String): Neo4j = {
    Neo4j(context).cypher(cypher)
  }

  /**
    * cypher READ/WRITE api
    * @param cypher
    * @param parameters
    * @return CypherResult
    */
  def exec(cypher: String, parameters: Map[String, AnyRef]): CypherResult = {
    Executor.execute(context, cypher, parameters)
  }

}
