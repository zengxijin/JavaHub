package com.jack.alg;

import com.jack.algorithm.power.Approach;
import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/16.
 */
public class ApproachTest {
    @Test
    public void testSquare() throws Exception {
        System.out.println(
                Approach.xsquare(100,3)
        );

        System.out.println(
                Math.pow(100d,1/3d)
        );

        System.out.println(
                Math.pow(1.584893191466108d,10)
        );

        System.out.println(
                Long.toBinaryString(2 << 8)
        );
    }
}
