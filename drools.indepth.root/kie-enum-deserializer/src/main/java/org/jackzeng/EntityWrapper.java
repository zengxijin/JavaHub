package org.jackzeng;

import java.io.Serializable;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public class EntityWrapper implements Serializable {

    private String stringField;
    private LoanStatus enumField;

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public LoanStatus getEnumField() {
        return enumField;
    }

    public void setEnumField(LoanStatus enumField) {
        this.enumField = enumField;
    }
}
