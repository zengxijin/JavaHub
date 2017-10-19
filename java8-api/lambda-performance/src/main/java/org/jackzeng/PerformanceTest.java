package org.jackzeng;

/**
 * Created by zengxj on 17-10-19
 */
public class PerformanceTest {

    public static void main(String[] args) {
        InnerClassSample innerClassSample = new InnerClassSample();
        long start = System.currentTimeMillis();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            innerClassSample.execute();
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }


}
