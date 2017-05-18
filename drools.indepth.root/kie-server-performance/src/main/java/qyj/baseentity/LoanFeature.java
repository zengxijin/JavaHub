package qyj.baseentity;


import common.entity.CreditStatus;
import common.entity.LoanStatus;
import common.entity.ProductName;

/**
 * @author weijiexie
 */
public class LoanFeature {

    public LoanFeature(){
        this.lastCreditResult = true;
        this.lastCreditStatus = CreditStatus.NONE;
        this.lastLoanStatus = LoanStatus.NONE;
        this.lastLoanMaxOverdueDays = -1;
        this.lastAppProduct = ProductName.NONE;
        this.appDaysFromLast = -1;
    }

    /**
     * 最近一次申请的审核结果
     */
    private Boolean lastCreditResult;

    /**
     * 最近一次申请的审核状态
     */
    private CreditStatus lastCreditStatus;

    /**
     * 最近一次贷款状态
     */
    private LoanStatus lastLoanStatus;


    /**
     * 最近一次贷款逾期天数
     */
    private int lastLoanMaxOverdueDays;

    /**
     * 最近一次申请产品
     */
    private ProductName lastAppProduct;

    /**
     * 本次申请距离最近一次申请的天数
     */
    private int appDaysFromLast;

    public Boolean getLastCreditResult() {
        return lastCreditResult;
    }

    public void setLastCreditResult(Boolean lastCreditResult) {
        this.lastCreditResult = lastCreditResult;
    }

    public CreditStatus getLastCreditStatus() {
        return lastCreditStatus;
    }

    public void setLastCreditStatus(CreditStatus lastCreditStatus) {
        this.lastCreditStatus = lastCreditStatus;
    }

    public LoanStatus getLastLoanStatus() {
        return lastLoanStatus;
    }

    public void setLastLoanStatus(LoanStatus lastLoanStatus) {
        this.lastLoanStatus = lastLoanStatus;
    }

    public int getLastLoanMaxOverdueDays() {
        return lastLoanMaxOverdueDays;
    }

    public void setLastLoanMaxOverdueDays(int lastLoanMaxOverdueDays) {
        this.lastLoanMaxOverdueDays = lastLoanMaxOverdueDays;
    }

    public ProductName getLastAppProduct() {
        return lastAppProduct;
    }

    public void setLastAppProduct(ProductName lastAppProduct) {
        this.lastAppProduct = lastAppProduct;
    }

    public int getAppDaysFromLast() {
        return appDaysFromLast;
    }

    public void setAppDaysFromLast(int appDaysFromLast) {
        this.appDaysFromLast = appDaysFromLast;
    }
}
