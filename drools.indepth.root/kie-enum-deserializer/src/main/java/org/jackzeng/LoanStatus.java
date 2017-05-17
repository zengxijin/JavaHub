package org.jackzeng;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public enum LoanStatus {
    UNPAYED("未结清"),
    PAYED("已结清"),
    NONE("无状态");

    private final String value;

    LoanStatus(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
