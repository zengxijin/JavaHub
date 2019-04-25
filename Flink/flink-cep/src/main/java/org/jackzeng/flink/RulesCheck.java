package org.jackzeng.flink;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author xijin.zeng created on 2018/12/14
 */
public class RulesCheck {
    private static final List<String> ANTI_FRAUD_ALL_MATCH_PASS = Lists.newArrayList("R1", "R2", "R3", "R4");
    private static Map<String, List<String>> SCENE_MAP_RULES = Maps.newHashMap();

    static {
        SCENE_MAP_RULES.put("payday-loan-anti-fraud", ANTI_FRAUD_ALL_MATCH_PASS);
    }

    public static String unorderedCheck(BizEvent bizEvent) {
        Map<String, Integer> rules = bizEvent.getHitRules();
        List<String> targetRules = SCENE_MAP_RULES.get(bizEvent.getScene());

        if (Objects.isNull(targetRules)) {
            return "SCENE_RULE_NOT_FOUND";
        }

        if (rules.keySet().size() < targetRules.size()) {
            return "PENDING";
        }

        List<String> list1 = Lists.newArrayList();
        rules.entrySet().forEach(entry -> {
            if (entry.getValue() > 0) {
                list1.add(entry.getKey());
            }
        });

        List<String> list2 = Lists.newArrayList();
        list2.addAll(ANTI_FRAUD_ALL_MATCH_PASS);
        Collections.sort(list1);
        Collections.sort(list2);

        return list2.equals(list1) ? "PASS" : "REJECT";
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("R2", 1);
        map.put("R4", 1);
        map.put("R3", 1);
        map.put("R1", 1);

//        BizEvent bizEvent = new BizEvent("001", "payday-loan-anti-fraud", )
//
//
//        System.out.println(unorderedCheck(map, ANTI_FRAUD_ALL_MATCH_PASS));
    }

}
