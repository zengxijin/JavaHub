package org.jackzeng.qyj;

import org.jackzeng.KieTestBase;
import org.junit.Test;
import qyj.baseentity.BasicFeature;
import qyj.bomentity.QyjMultiloanBom;
import qyj.ruleresult.CreditResult;

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/5/18.
 */

public class Q_O001Test {

    @Test
    public void Q_O001() throws Exception {
        QyjMultiloanBom bom = new QyjMultiloanBom();
        BasicFeature feature = new BasicFeature();
        feature.setAge(1);
        //feature.setLoanFeature();
        bom.setBasicFeature(feature);

        CreditResult result = new CreditResult();

        System.out.println(
            KieTestBase.runTest("ks-qyj-multiloan-stateful", Arrays.<Object>asList(bom , result))
        );

    }
}
