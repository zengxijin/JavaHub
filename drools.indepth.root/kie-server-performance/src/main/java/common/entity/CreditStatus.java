package common.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * @author weijiexie
 */
public enum CreditStatus {
    ISSUE("已结清"),

    ISSUEING("审核中"),

    NONE("无状态"),
    ;

    private final String value;

    CreditStatus(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return this.value;
    }

    @JsonCreator
    public static CreditStatus forValue(String value) {
        if(value == null){
            return null;
        }

        for (CreditStatus e : CreditStatus.values()){
            if(e.getValue().equals(value)){
                return e;
            }
        }
        throw new IllegalArgumentException("unexpected value [" + value + "]");
    }

    @Override
    public String toString(){
        return this.value;
    }
}
