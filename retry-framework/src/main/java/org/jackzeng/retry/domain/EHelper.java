package org.jackzeng.retry.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengxijin created on 2017/8/27
 */
public class EHelper {

    private EHelper(){}

    private static final Map<E1,E2> MAPPER = new HashMap<>();

    static {
        MAPPER.put(E1.PASS,E2.PASS);
        MAPPER.put(E1.REJECT,E2.REJECT);
    }

    public static E2 getMapping(E1 e1){
        return MAPPER.get(e1);
    }
}
