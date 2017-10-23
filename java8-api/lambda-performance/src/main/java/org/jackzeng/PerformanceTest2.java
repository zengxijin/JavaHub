package org.jackzeng;

/**
 * Created by zengxj on 17-10-19
 */
public class PerformanceTest2 {

    public static void main(String[] args) {
        LambdaSample lambdaSample = new LambdaSample();
        long start = System.currentTimeMillis();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            lambdaSample.execute();
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }
}
