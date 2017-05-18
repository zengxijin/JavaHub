package qyj.ruleresult;


import java.util.ArrayList;
import java.util.List;

/**
 * @author weijiexie
 */
public class CreditResult {

    public CreditResult(){
        this.creditResult = true;
        this.hitRules = new ArrayList<RuleResult>();
    }

    /**
     * 审核结果
     */
    private boolean creditResult;

    /**
     * 触碰的规则
     */
    private List<RuleResult> hitRules;

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
