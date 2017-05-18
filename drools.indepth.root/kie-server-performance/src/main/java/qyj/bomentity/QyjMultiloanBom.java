package qyj.bomentity;


import qyj.baseentity.BasicFeature;

/**
 * @author weijiexie
 */
public class QyjMultiloanBom {

    public QyjMultiloanBom(){
        this.basicFeature = new BasicFeature();
    }

    private BasicFeature basicFeature;

    private String policyId;

    private String appId;

    private String transactionId;

    private String timestamp;

    public BasicFeature getBasicFeature() {
        return basicFeature;
    }

    public void setBasicFeature(BasicFeature basicFeature) {
        this.basicFeature = basicFeature;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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
}
