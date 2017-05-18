package org.jackzeng.pdl;

import org.jackzeng.KieTestBase;
import org.junit.Test;
import pdl.bomentity.ThirdPartyBom;
import pdl.ruleresult.CreditResult;

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/5/18.
 */
public class P_O001Test {
    @Test
    public void P_O001() throws Exception {
        ThirdPartyBom thirdPartyBom = new ThirdPartyBom();
        CreditResult creditResult = new CreditResult();

        System.out.println(
                KieTestBase.runTest(SessionConfig.PDL_STATEFUL_SESSION, Arrays.asList(thirdPartyBom, creditResult))
        );

    }
}
