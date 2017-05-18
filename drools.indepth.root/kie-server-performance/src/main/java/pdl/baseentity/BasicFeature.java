package pdl.baseentity;


/**
 * @author weijiexie
 */
public class BasicFeature {

    public BasicFeature(){
        this.age = -1;
        this.loanFeature = new LoanFeature();
    }

    private int age;

    private LoanFeature loanFeature;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LoanFeature getLoanFeature() {
        return loanFeature;
    }

    public void setLoanFeature(LoanFeature loanFeature) {
        this.loanFeature = loanFeature;
    }
}
