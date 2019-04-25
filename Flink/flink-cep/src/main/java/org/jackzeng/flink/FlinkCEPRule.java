package org.jackzeng.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.AbstractDeserializationSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.nfa.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.shaded.guava18.com.google.common.base.Strings;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;
import org.apache.flink.util.Collector;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author xijin.zeng created on 2018/12/14
 */
public class FlinkCEPRule {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        FlinkKafkaConsumer09<RuleResult> consumer = Util.ruleResultConsumer(args);
        DataStream<RuleResult> dataStream = environment.addSource(consumer);

        dataStream.print();

        /**
         * 匹配所有的RuleResult事件
         */
        Pattern<RuleResult, RuleResult> ruleResultPattern = Pattern.<RuleResult>begin("payday-loan", AfterMatchSkipStrategy.skipPastLastEvent())
                .subtype(RuleResult.class)
                .where(new IterativeCondition<RuleResult>() {
                    @Override
                    public boolean filter(RuleResult value, Context<RuleResult> ctx) throws Exception {
                        // 有效的业务代码， 是否是payday-loan反欺诈场景
                        return !Strings.isNullOrEmpty(value.getBizCode()) && "payday-loan-anti-fraud".equals(value.getScene());
                    }
                })
                //规则触发次数大于等于4次
                .timesOrMore(4); //R1,R2,R3,R2,R4 => 匹配出2个模式：错误 R1,R2,R3,R2(REJECT) 正确：R1,R2,R3,R2,R4（PASS）
                //.times(4).greedy();



        /**
         * 将RuleResult事件基于每笔业务进行分组
         * 得到Map<String, List<RuleResult>>, key为事件名称，如"begin-rule"，value为匹配的数据列表，每一个entry是对应的<bizCode,List<RuleResult>>
         */
        PatternStream<RuleResult> patternStream = CEP.pattern(
                dataStream.keyBy(x -> x.getBizCode()),
                ruleResultPattern
        );

        /**
         * 将满足pattern的event事件select出来，形成新的BizEvent事件流
         */
//        DataStream<BizEvent> bizEventDataStream = patternStream
//                .select(
//                        (Map<String, List<RuleResult>> entry) -> {
//                            List<RuleResult> results = entry.get("payday-loan");
//                            RuleResult event = results.get(0);
//                            return new BizEvent(event.getBizCode(), event.getScene(), results);
//                        }
//                ).returns(BizEvent.class);

        DataStream<BizEvent> bizEventDataStream = patternStream.select(new PatternSelectFunction<RuleResult, BizEvent>() {
            @Override
            public BizEvent select(Map<String, List<RuleResult>> pattern) throws Exception {
                List<RuleResult> results = pattern.get("payday-loan");
                            RuleResult event = results.get(0);
                            return new BizEvent(event.getBizCode(), event.getScene(), results);
            }
        });

        bizEventDataStream.print();

        //对lambda的写法貌似不支持
//        The return type of function 'main(FlinkCEPRule.java:22)' could not be determined automatically, due to type erasure. You can give type information hints by using the returns(...) method on the result of the transformation call, or by letting your function implement the 'ResultTypeQueryable' interface.
//        org.apache.flink.streaming.api.transformations.StreamTransformation.getOutputType(StreamTransformation.java:382)
//        org.apache.flink.streaming.api.datastream.DataStream.addSink(DataStream.java:1127)
//        org.apache.flink.streaming.api.datastream.DataStream.writeUsingOutputFormat(DataStream.java:1066)
//        org.apache.flink.streaming.api.datastream.DataStream.writeAsText(DataStream.java:952)
//        org.jackzeng.flink.FlinkCEPRule.main(FlinkCEPRule.java:28)

        /* 原因
        In order to execute a program, Flink needs to know the type of the values that are processed
        because it needs to serialize and deserialize them. Flink's type system is based on TypeInformation
        which describes a data type. When you specify a function, Flink tries to infer the return type of that function.
        In case of the FlatMapFunction of your example the type of the objects that are passed to the Collector.

        Unfortunately, some Lambda functions lose this information due to type erasure such that
        Flink cannot automatically infer the type. Therefore, you have to explicitly declare the return type.

        解决方式就是在returns后面显示加上需要返回的类型，比如returns(Types.STRING)
        */

//        SingleOutputStreamOperator<String> outputStreamOperator = dataStream.flatMap(
//                (x, y) -> {
//                    y.collect(x.toString());
//                }
//        );

//        SingleOutputStreamOperator<String> outputStreamOperator = dataStream.flatMap(
//                (RuleResult x, Collector<String> y) -> y.collect(x.toString())
//        ).returns(Types.STRING);


//        SingleOutputStreamOperator<String> outputStreamOperator = dataStream.flatMap(
//                new FlatMapFunction<RuleResult, String>() {
//                    @Override
//                    public void flatMap(RuleResult value, Collector<String> out) throws Exception {
//                        out.collect(value.toString());
//                    }
//                }
//        );

        SingleOutputStreamOperator<String> outputStreamOperator = bizEventDataStream.flatMap(
                (BizEvent x, Collector<String> y) -> y.collect(x.toString())
        ).returns(Types.STRING);
        outputStreamOperator.writeAsText("/tmp/rule-result.txt", FileSystem.WriteMode.OVERWRITE);

        environment.execute("CEP-RuleResultDemo");

    }

}
