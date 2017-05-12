package com.qf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public enum LoanStatus {
    UNPAYED("未结清"),
    PAYED("已结清"),
    NONE("无状态");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    LoanStatus(String value){
        this.value = value;
    }

    public String toString(){
        return this.value;
    }

    @JsonCreator
    public static LoanStatus create(String value){
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
