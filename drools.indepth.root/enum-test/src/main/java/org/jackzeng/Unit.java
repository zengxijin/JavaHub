package org.jackzeng;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by XijinZeng on 2017/5/11.
 */
public enum Unit {
    A1("我是A1"),
    A2("我是A2");

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    Unit(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
