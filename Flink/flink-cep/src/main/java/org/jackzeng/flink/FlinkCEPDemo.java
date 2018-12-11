package org.jackzeng.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;
import org.apache.flink.util.Collector;


import java.util.Properties;

/**
 * @author xijin.zeng created on 2018/12/10
 */
public class FlinkCEPDemo {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        // 每2秒做一次checkpoint
        //executionEnvironment.enableCheckpointing(2000);

        FlinkKafkaConsumer09<String> consumer09 = getKafkaConsumer(args);
        DataStream<String> stream = executionEnvironment.addSource(consumer09);

        DataStream<Tuple2<String, Integer>> wordCounts = stream.flatMap(new Tokenizer()).keyBy(0).sum(1);

        // sink to file
        SingleOutputStreamOperator<String> outputStreamOperator = wordCounts.flatMap(new FlatMapFunction<Tuple2<String, Integer>, String>() {
            @Override
            public void flatMap(Tuple2<String, Integer> value, Collector<String> out) throws Exception {
                out.collect(value.f0 + ":" + value.f1);
            }
        });
        outputStreamOperator.writeAsText("/tmp/out.txt", FileSystem.WriteMode.OVERWRITE);

        executionEnvironment.execute("WordCountDemo");

    }

    private static FlinkKafkaConsumer09<String> getKafkaConsumer(String[] args) {
        Properties properties = new Properties();
        ParameterTool parameterTool = ParameterTool.fromArgs(args);

        properties.setProperty("bootstrap.servers", parameterTool.get("bootstrap.servers"));
        properties.setProperty("zookeeper.connect", parameterTool.get("zookeeper.connect"));
        properties.setProperty("group.id", parameterTool.get("group.id"));
        properties.setProperty("topic", parameterTool.get("topic"));

        String topic = properties.getProperty("topic");

        return new FlinkKafkaConsumer09<String>(topic, new SimpleStringSchema(), properties);
    }

    public static class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            final String tempValue = value == null ? "" : value;
            String[] strs = tempValue.toLowerCase().split("\\W+");
            for (String str : strs) {
                if (str.length() > 0) {
                    out.collect(new Tuple2<>(str, 1));
                }
            }
        }
    }
}
