package org.jackzeng;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by XijinZeng on 2017/5/12.
 */

public enum HelloEnum {
    HELLO("h"),
    WORLD("w");

    private final String value;

    HelloEnum (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static HelloEnum create (String value) {
        if(value == null) {
            throw new IllegalArgumentException();
        }
        for(HelloEnum v : values()) {
            if(value.equals(v.getValue())) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }


}