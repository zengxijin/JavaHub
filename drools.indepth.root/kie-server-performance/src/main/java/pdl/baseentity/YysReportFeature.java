package pdl.baseentity;


/**
 * @author weijiexie
 */
public class YysReportFeature {

    public YysReportFeature(){
        this.reliabilityDays = -1;
        this.checkIdCard = false;
        this.checkName = false;
    }

    private int reliabilityDays;

    private boolean checkIdCard;

    private boolean checkName;

    public int getReliabilityDays() {
        return reliabilityDays;
    }

    public void setReliabilityDays(int reliabilityDays) {
        this.reliabilityDays = reliabilityDays;
    }

    public boolean isCheckIdCard() {
        return checkIdCard;
    }

    public void setCheckIdCard(boolean checkIdCard) {
        this.checkIdCard = checkIdCard;
    }

    public boolean isCheckName() {
        return checkName;
    }

    public void setCheckName(boolean checkName) {
        this.checkName = checkName;
    }
}
