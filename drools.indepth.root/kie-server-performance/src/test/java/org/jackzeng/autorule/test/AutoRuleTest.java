package org.jackzeng.autorule.test;

import org.jackzeng.KieTestBase;
import org.jackzeng.autobean.Bean1;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/5/22.
 */
public class AutoRuleTest {
    @Test
    public void testRule() throws Exception {
        Bean1 bean1 = new Bean1();
        bean1.setField1("String");
        bean1.setField2(102.1d);
        bean1.setField3(true);
        bean1.setFild4(100);

        System.out.println(
                KieTestBase.runTest("autorule-stateful", Arrays.asList(bean1))
        );

    }
}
