package org.jackzeng.autobean;

/**
 * Created by XijinZeng on 2017/5/22.
 */
public class RuleResult {

    private boolean ruleResult;

    private String ruleName;

    private String description;

    private int score;

    public boolean isRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(boolean ruleResult) {
        this.ruleResult = ruleResult;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
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

    public String toString() {
        return "[ruleName=" + ruleName + " ruleResult=" + ruleResult +
                " score=" + score + " description=" + description + "]";
    }
}
