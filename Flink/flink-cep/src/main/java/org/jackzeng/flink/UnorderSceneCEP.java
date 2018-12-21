package org.jackzeng.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;

/**
 * @author xijin.zeng created on 2018/12/20
 */
public class UnorderSceneCEP {

    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        FlinkKafkaConsumer09<RuleResult> kafkaConsumer09 = Util.ruleResultConsumer(args);
        DataStream<RuleResult> dataStream = env.addSource(kafkaConsumer09);


    }
}
