package org.jackzeng;

import java.io.Serializable;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public class EntityWrapperNew implements Serializable {
    private String stringField;
    private LoanStatusNew enumField;

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public LoanStatusNew getEnumField() {
        return enumField;
    }

    public void setEnumField(LoanStatusNew enumField) {
        this.enumField = enumField;
    }
}
