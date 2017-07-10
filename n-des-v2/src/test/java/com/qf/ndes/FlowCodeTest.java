package com.qf.ndes;

import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/21.
 */
public class FlowCodeTest {
    @Test
    public void flowCodeTest() throws Exception {
        System.out.println(
                Long.toBinaryString(2L << 2 | 2L << 3)

        );



        System.out.println(
                Long.toBinaryString(0)

        );
    }
}
