package org.jackzeng.flink;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xijin.zeng created on 2018/12/14
 */
@Data
public class BizEvent {

    private String bizCode;
    private String scene;
    private String checkResult;

    private Map<String, Integer> hitRules = new HashMap<>();

    public BizEvent(String bizCode, String scene, List<RuleResult> ruleCodes) {
        this.bizCode = bizCode;
        this.scene = scene;

        ruleCodes.forEach(
                ruleResult -> {
                    String ruleCode = ruleResult.getRuleCode();
                    if (hitRules.containsKey(ruleCode) && ruleResult.isRuleHit()) {
                        Integer counts = hitRules.get(ruleCode);
                        hitRules.put(ruleCode, counts + 1);
                    } else {
                        if (ruleResult.isRuleHit()) {
                            hitRules.put(ruleCode, 1);
                        } else {
                            hitRules.put(ruleCode, 0);
                        }
                    }
                }
        );

        checkResult = RulesCheck.unorderedCheck(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        hitRules.entrySet().forEach(
                e -> builder.append(e.getKey() + ":" + String.valueOf(e.getValue()) + " ")
        );

        return "BizEvent{" +
                "bizCode='" + bizCode + '\'' +
                ", scene='" + scene + '\'' +
                ", checkResult='" + checkResult + '\'' +
                ", hitRules=" + builder.toString() +
                '}';
    }
}
