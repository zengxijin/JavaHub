package pdl.baseentity;


public class IntersectionFeature {

    public IntersectionFeature(){
        this.yysDetailLoanFeature = new YysDetailLoanFeature();
    }

    public YysDetailLoanFeature getYysDetailLoanFeature() {
        return yysDetailLoanFeature;
    }

    public void setYysDetailLoanFeature(YysDetailLoanFeature yysDetailLoanFeature) {
        this.yysDetailLoanFeature = yysDetailLoanFeature;
    }

    private YysDetailLoanFeature yysDetailLoanFeature;
}
