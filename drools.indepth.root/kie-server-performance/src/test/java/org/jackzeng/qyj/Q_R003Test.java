package org.jackzeng.qyj;

import org.jackzeng.KieTestBase;
import org.junit.Test;
import qyj.baseentity.BasicFeature;
import qyj.baseentity.LoanFeature;
import qyj.bomentity.QyjMultiloanBom;
import qyj.ruleresult.CreditResult;

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/5/18.
 */
public class Q_R003Test {
    @Test
    public void Q_R003() throws Exception {
//        $qmb : QyjMultiloanBom($qmb.basicFeature.loanFeature.lastCreditResult == false
//                && $qmb.basicFeature.loanFeature.appDaysFromLast <= 30)
//        $cr : CreditResult()

        QyjMultiloanBom qyjMultiloanBom = new QyjMultiloanBom();
        BasicFeature basicFeature = new BasicFeature();
        LoanFeature loanFeature = new LoanFeature();
        loanFeature.setLastCreditResult(false);
        loanFeature.setAppDaysFromLast(20);
        basicFeature.setLoanFeature(loanFeature);

        qyjMultiloanBom.setBasicFeature(basicFeature);

        CreditResult creditResult = new CreditResult();

        System.out.println(
                KieTestBase.runTest(SessionConfig.QYJ_STATEFUL_SESSION, Arrays.asList(qyjMultiloanBom, creditResult))
        );

    }
}
