package org.jackzeng.flink;

import lombok.Data;

/**
 * @author xijin.zeng created on 2018/12/14
 */
@Data
public class RuleResult {
    //表示唯一的一笔业务
    private String bizCode;
    //规则名称
    private String ruleName;
    //场景
    private String scene;

    //是否激活规则
    private boolean ruleHit;
    //规则编码
    private String ruleCode;
}


