package org.jackzeng.neo4j.data.constant;

/**
 * @author xijin.zeng created on 2018/5/10
 */
public enum LoanStatus {
    NORMAL("NORMAL123"),   //正常
    OVERDUE("OVERDUE"), //逾期
    CLEAR("CLEAR");     //结清

    private String val;

    LoanStatus(String val) {
        this.val = val;
    }
}
