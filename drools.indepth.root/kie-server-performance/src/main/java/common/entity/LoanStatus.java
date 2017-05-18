package common.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * @author weijiexie
 */
public enum LoanStatus {
    UNPAYED("未结清"),
    PAYED("已结清"),
    NONE("无状态")
    ;

    private final String value;

    LoanStatus(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return this.value;
    }

    @JsonCreator
    public static LoanStatus forValue(String value){
        if(value == null){
            return null;
        }
        for(LoanStatus e: LoanStatus.values()){
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
