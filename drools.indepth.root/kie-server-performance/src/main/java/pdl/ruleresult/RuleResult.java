package pdl.ruleresult;


import pdl.baseentity.Rule;

/**
 * @author weijiexie
 */
public class RuleResult {

    private boolean ruleResult;

    private Rule ruleName;

    private String description;

    private int score;

    public boolean isRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(boolean ruleResult) {
        this.ruleResult = ruleResult;
    }

    public Rule getRuleName() {
        return ruleName;
    }

    public void setRuleName(Rule ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
