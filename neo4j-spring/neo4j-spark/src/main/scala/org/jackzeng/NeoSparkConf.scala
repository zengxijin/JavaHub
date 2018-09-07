package org.jackzeng

import org.apache.spark.SparkConf

/**
  * @author xijin.zeng created on 2018/9/7
  */
object NeoSparkConf {
  val DEFAULT_TEST_MEMORY = "2147480000"
  val LOCAL_HOST = "local[*]"

  def getConf(boltUri: String, user: String, password: String, appName: String, master: String, testMem: String): SparkConf = {
    new SparkConf().setAppName(appName).setMaster(master)
      .set("spark.neo4j.bolt.url", boltUri)
      .set("spark.neo4j.bolt.user", user)
      .set("spark.neo4j.bolt.password", password)
      .set("spark.driver.allowMultipleContexts", "true")
      //need to set the memory avoid to running error in localhost
      .set("spark.testing.memory", testMem)
  }

  def getLocalConf(boltUri: String, user: String, password: String, appName: String): SparkConf = {
    getConf(boltUri, user, password, appName, LOCAL_HOST, DEFAULT_TEST_MEMORY)
  }
}
