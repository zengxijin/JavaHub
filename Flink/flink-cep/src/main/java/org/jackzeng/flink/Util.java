package org.jackzeng.flink;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;

import java.util.Properties;

/**
 * @author xijin.zeng created on 2018/12/14
 */
public class Util {
    public static Properties parseParams(String[] args) {
        Properties properties = new Properties();
        ParameterTool parameterTool = ParameterTool.fromArgs(args);

        properties.setProperty("bootstrap.servers", parameterTool.get("bootstrap.servers"));
        properties.setProperty("zookeeper.connect", parameterTool.get("zookeeper.connect"));
        properties.setProperty("group.id", parameterTool.get("group.id"));
        properties.setProperty("topic", parameterTool.get("topic"));

        return properties;
    }

    public static FlinkKafkaConsumer09<RuleResult> ruleResultConsumer(String[] args) {
        Properties properties = Util.parseParams(args);
        return new FlinkKafkaConsumer09<RuleResult>(properties.getProperty("topic"), new RuleResultSchema(), properties);
    }
}
