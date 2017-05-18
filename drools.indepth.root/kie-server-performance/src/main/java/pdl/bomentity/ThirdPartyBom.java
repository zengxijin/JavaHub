package pdl.bomentity;


import pdl.baseentity.*;

/**
 * @author weijiexie
 */
public class ThirdPartyBom {

    public ThirdPartyBom(){
        this.basicFeature = new BasicFeature();
        this.yysReportFeature = new YysReportFeature();
        this.yysDetailFeature = new YysDetailFeature();
        this.intersectionFeature = new IntersectionFeature();
        this.zhimaFeature = new ZhimaFeature();
    }

    private String policyId;

    private String appId;

    private String transactionId;

    private String timestamp;

    private BasicFeature basicFeature;

    private YysReportFeature yysReportFeature;

    private YysDetailFeature yysDetailFeature;

    private IntersectionFeature intersectionFeature;

    private ZhimaFeature zhimaFeature;

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

    public BasicFeature getBasicFeature() {
        return basicFeature;
    }

    public void setBasicFeature(BasicFeature basicFeature) {
        this.basicFeature = basicFeature;
    }

    public YysReportFeature getYysReportFeature() {
        return yysReportFeature;
    }

    public void setYysReportFeature(YysReportFeature yysReportFeature) {
        this.yysReportFeature = yysReportFeature;
    }

    public YysDetailFeature getYysDetailFeature() {
        return yysDetailFeature;
    }

    public void setYysDetailFeature(YysDetailFeature yysDetailFeature) {
        this.yysDetailFeature = yysDetailFeature;
    }

    public IntersectionFeature getIntersectionFeature() {
        return intersectionFeature;
    }

    public void setIntersectionFeature(IntersectionFeature intersectionFeature) {
        this.intersectionFeature = intersectionFeature;
    }

    public ZhimaFeature getZhimaFeature() {
        return zhimaFeature;
    }

    public void setZhimaFeature(ZhimaFeature zhimaFeature) {
        this.zhimaFeature = zhimaFeature;
    }
}
