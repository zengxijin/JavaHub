package org.jackzeng;

import org.jackzeng.politician.Politician;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by XijinZeng on 2017/5/17.
 */
public class RuleTest {

    final String statefulSession = "kie-performance-stateful";

    //@Test
    public void testFibonacci() throws Exception {
        List<Object> objectList = new ArrayList<Object>();
        Fibonacci fibonacci = new Fibonacci(50);
        objectList.add(fibonacci);


        int firedRule = KieTestBase.runTest("kie-performance-stateful",objectList);
        System.out.println(firedRule);
    }

    @Test
    public void testPolitician() throws Exception {
        Politician politician = new Politician();
        politician.setHonest(true);
        politician.setName("jackZeng");

        System.out.println(
                KieTestBase.runTest(statefulSession, Arrays.<Object>asList(politician))
        );

        

    }
}
