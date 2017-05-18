package common.entity;


import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * @author weijiexie
 */
public enum ProductName {
    QYJ("Q易借"),
    PDL("暖薪贷"),
    NONE(""),
    ;

    private final String value;

    ProductName(String value){
        this.value = value ;
    }


    @JsonValue
    public String getValue(){
        return value;
    }

    @JsonCreator
    public static ProductName forValue(String value){
        if(value == null){
            return null;
        }
        for(ProductName e: values()){
            if(e.getValue().equals(value)){
                return e;
            }
        }

        throw new IllegalArgumentException("unexpected value [" + value + "]");
    }

    @Override
    public String toString() {
        return this.value;
    }


}
