package org.jackzeng;

/**
 * @author zengxijin created on 2017/8/23
 */
public enum ThirdPartyEnum {

    ABC("abc","123"),
    EFG("efg","456")
    ;

    private String value;
    private String other;

    ThirdPartyEnum(String value, String other){
        this.value = value;
        this.other = other;
    }
}
