package org.jackzeng.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengxj
 * @create 2017/11/6
 */
public class InstanceMethodDemo {

    //add members
    private int a;
    private int b;
    private Map<String,String> map = new HashMap<>();

    public int dummyMethodV1(int a, int b) {
        this.a = a;
        this.b = b;
        return (this.a + this.b);
    }

    public int dummyMethodV2(int a, int b) {
        this.a = a;
        this.b = b;
        return (this.a + this.b) * 2;
    }
}
