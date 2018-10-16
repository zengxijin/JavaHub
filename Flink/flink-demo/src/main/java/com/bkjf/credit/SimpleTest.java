package com.bkjf.credit;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author xijin.zeng created on 2018/10/16
 */
public class SimpleTest {

    public static void main(String[] args) {
        DataStream<String> dataStream = null;

        //(1) setup env for Stream mode
        final StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        // setup env for Batch mode
        // final ExecutionEnvironment bathEnv = ExecutionEnvironment.getExecutionEnvironment();

        //(2) setup input datasource
        final ParameterTool inputParams = ParameterTool.fromArgs(args);
        if (inputParams.has("src") && inputParams.has("dst")) {
            executionEnvironment.getConfig().setGlobalJobParameters(inputParams);
            dataStream = executionEnvironment.readTextFile(inputParams.get("src"));
        } else {
            System.out.println("warn: invalid params");
            System.out.println("usage: <EntryClass> --src <input-path-file> --dst <output-path-file>");
            return;
        }

        //(3) transformation operation
        SingleOutputStreamOperator<String> outputStreamOperator = dataStream.map(s -> s.toUpperCase());

        //(4) output data to sink
        outputStreamOperator.writeAsText(inputParams.get("dst"), FileSystem.WriteMode.OVERWRITE);

        // start run
        try {
            executionEnvironment.execute("SimpleUpperCaseJob");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
