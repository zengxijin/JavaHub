package com.jack.alg;

import com.jack.algorithm.power.NewtonIteration;
import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/18.
 */
public class NewtonIterationTest {
    @Test
    public void getSquareRootTest() throws Exception {
        System.out.println(
                NewtonIteration.getSquareRoot(4)
        );
    }
}
