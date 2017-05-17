package com.qf;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public enum LoanStatus {
    UNPAYED("未结清"),
    PAYED("已结清"),
    NONE("无状态");

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return this.value;
    }

    private final String value;

    LoanStatus(String value){
        this.value = value;
    }

    @JsonCreator
    public static LoanStatus forValue(String value) {
        if(value == null){
            return null;
        }

        for (LoanStatus e : values()){
            if(e.getValue().equals(value)){
                return e;
            }
        }

        throw new IllegalArgumentException();
    }

}
