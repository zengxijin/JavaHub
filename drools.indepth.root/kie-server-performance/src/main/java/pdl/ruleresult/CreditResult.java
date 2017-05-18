package pdl.ruleresult;


import java.util.ArrayList;
import java.util.List;

/**
 * @author weijiexie
 */
public class CreditResult {

    public CreditResult(){
        this.creditResult = false;
        this.hitRules = new ArrayList<RuleResult>();
    }

    /**
     * 审核结果
     */
    public boolean creditResult;

    /**
     * 触碰的规则
     */
    public List<RuleResult> hitRules;

    public boolean isCreditResult() {
        return creditResult;
    }

    public void setCreditResult(boolean creditResult) {
        this.creditResult = creditResult;
    }

    public List<RuleResult> getHitRules() {
        return hitRules;
    }

    public void setHitRules(List<RuleResult> hitRules) {
        this.hitRules = hitRules;
    }
}
