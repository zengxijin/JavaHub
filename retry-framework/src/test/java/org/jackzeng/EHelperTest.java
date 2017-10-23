package org.jackzeng;

import org.jackzeng.retry.domain.E1;
import org.jackzeng.retry.domain.E2;
import org.jackzeng.retry.domain.EHelper;

/**
 * @author zengxijin created on 2017/8/27
 */
public class EHelperTest {
    public static void main(String[] args) {
        E1 e1 = E1.REJECT;

        E2 e2 = EHelper.getMapping(e1);

        System.out.println(
                e2
        );
    }
}
