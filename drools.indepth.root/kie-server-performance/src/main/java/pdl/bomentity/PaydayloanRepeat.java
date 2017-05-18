package pdl.bomentity;

import pdl.baseentity.BasicFeature;

/**
 * @author weijiexie
 */
public class PaydayloanRepeat {

    private String policyId;

    private String loanAppId;

    private String transactionId;

    private String timestamp;

    private BasicFeature basicFeature;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getLoanAppId() {
        return loanAppId;
    }

    public void setLoanAppId(String loanAppId) {
        this.loanAppId = loanAppId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public BasicFeature getBasicFeature() {
        return basicFeature;
    }

    public void setBasicFeature(BasicFeature basicFeature) {
        this.basicFeature = basicFeature;
    }
}
