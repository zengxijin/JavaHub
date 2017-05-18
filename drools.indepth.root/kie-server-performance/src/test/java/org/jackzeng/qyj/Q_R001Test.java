package org.jackzeng.qyj;

import common.entity.CreditStatus;
import common.entity.LoanStatus;
import common.entity.ProductName;
import org.jackzeng.KieTestBase;
import org.junit.Test;
import qyj.baseentity.BasicFeature;
import qyj.baseentity.LoanFeature;
import qyj.bomentity.QyjMultiloanBom;
import qyj.ruleresult.CreditResult;
import qyj.ruleresult.RuleResult;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/5/18.
 */
public class Q_R001Test {

    @Test
    public void Q_R001() throws Exception {
        BasicFeature feature = new BasicFeature();
        LoanFeature loanFeature = new LoanFeature();
        loanFeature.setLastAppProduct(ProductName.QYJ);
        loanFeature.setLastCreditStatus(CreditStatus.ISSUE);
        loanFeature.setLastLoanStatus(LoanStatus.UNPAYED);
        feature.setLoanFeature(loanFeature);

        QyjMultiloanBom bom = new QyjMultiloanBom();
        bom.setBasicFeature(feature);

        CreditResult creditResult = new CreditResult();
        creditResult.setHitRules(new ArrayList<RuleResult>());

        System.out.println(
                KieTestBase.runTest("ks-qyj-multiloan-stateful", Arrays.asList(bom, creditResult))
        );
    }
}
