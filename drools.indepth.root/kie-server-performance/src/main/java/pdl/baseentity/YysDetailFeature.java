package pdl.baseentity;


/**
 * @author weijiexie
 */
public class YysDetailFeature {

    public YysDetailFeature(){
        this.juxinliDetailEmptyOrNot = true;
        this.Sms2wayTotRcrdSumJ30d = -1;
        this.Net2wayTotRcrdSumJ30d = -1;
        this.Call2wayTotRcrdSumJ30d = -1;
        this.Call2wayTotUnqnSumJ90d = -1;
    }

    private boolean juxinliDetailEmptyOrNot;

    private int Sms2wayTotRcrdSumJ30d;

    private int Net2wayTotRcrdSumJ30d;

    private int Call2wayTotRcrdSumJ30d;

    private int Call2wayTotUnqnSumJ90d;

    public boolean isJuxinliDetailEmptyOrNot() {
        return juxinliDetailEmptyOrNot;
    }

    public void setJuxinliDetailEmptyOrNot(boolean juxinliDetailEmptyOrNot) {
        this.juxinliDetailEmptyOrNot = juxinliDetailEmptyOrNot;
    }

    public int getSms2wayTotRcrdSumJ30d() {
        return Sms2wayTotRcrdSumJ30d;
    }

    public void setSms2wayTotRcrdSumJ30d(int sms2wayTotRcrdSumJ30d) {
        Sms2wayTotRcrdSumJ30d = sms2wayTotRcrdSumJ30d;
    }

    public int getNet2wayTotRcrdSumJ30d() {
        return Net2wayTotRcrdSumJ30d;
    }

    public void setNet2wayTotRcrdSumJ30d(int net2wayTotRcrdSumJ30d) {
        Net2wayTotRcrdSumJ30d = net2wayTotRcrdSumJ30d;
    }

    public int getCall2wayTotRcrdSumJ30d() {
        return Call2wayTotRcrdSumJ30d;
    }

    public void setCall2wayTotRcrdSumJ30d(int call2wayTotRcrdSumJ30d) {
        Call2wayTotRcrdSumJ30d = call2wayTotRcrdSumJ30d;
    }

    public int getCall2wayTotUnqnSumJ90d() {
        return Call2wayTotUnqnSumJ90d;
    }

    public void setCall2wayTotUnqnSumJ90d(int call2wayTotUnqnSumJ90d) {
        Call2wayTotUnqnSumJ90d = call2wayTotUnqnSumJ90d;
    }
}
