package org.jackzeng.truck;

/**
 * @author zengxj
 * @create 2017/12/1
 */
public class HiveOps {
//    object RawDeserializeTest {
//
//        def main(args: Array[String]): Unit = {
//                val sc = new SparkContext(new SparkConf().setMaster("local").setAppName("RawDeserializeTestJob"))
//                val hiveSqlContext = new HiveContext(sc)
//
//                val sql = "select raw from test.afe_policy_execution_data where data_src_type='juxinliDetail' and dw_audit_cre_date='2017-11-01' limit 10"
//                val result = hiveSqlContext.sql(sql)
//                result.rdd.foreach(f => {
//                        val reponse = JacksonUtil.getObjectMapper.readValue(f.getString(0), classOf[DetailReportResponse])
//                        val mapper: ObjectMapper = new ObjectMapper()
//        println(mapper.writeValueAsString(reponse))
//    })
//
//  }
//
//    }
}
