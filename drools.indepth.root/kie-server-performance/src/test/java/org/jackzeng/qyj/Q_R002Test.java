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

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/5/18.
 */
public class Q_R002Test {
    @Test
    public void Q_R002() throws Exception {

        QyjMultiloanBom qyjMultiloanBom = new QyjMultiloanBom();
        BasicFeature basicFeature = new BasicFeature();
        LoanFeature loanFeature = new LoanFeature();
        loanFeature.setLastAppProduct(ProductName.QYJ);
        loanFeature.setLastCreditStatus(CreditStatus.ISSUE);
        loanFeature.setLastLoanStatus(LoanStatus.PAYED);
        loanFeature.setLastLoanMaxOverdueDays(40);

        basicFeature.setLoanFeature(loanFeature);
        qyjMultiloanBom.setBasicFeature(basicFeature);

        CreditResult creditResult = new CreditResult();

        System.out.println(
                KieTestBase.runTest("ks-qyj-multiloan-stateful", Arrays.asList(qyjMultiloanBom, creditResult))
        );

    }
}
