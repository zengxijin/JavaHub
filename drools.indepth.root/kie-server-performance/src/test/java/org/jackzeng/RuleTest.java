package org.jackzeng;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XijinZeng on 2017/5/17.
 */
public class RuleTest {

    @Test
    public void testFibonacci() throws Exception {
        List<Object> objectList = new ArrayList<Object>();
        Fibonacci fibonacci = new Fibonacci(50);
        objectList.add(fibonacci);


        int firedRule = KieTestBase.runTest("kie-performance-stateful",objectList);
        System.out.println(firedRule);
    }
}
