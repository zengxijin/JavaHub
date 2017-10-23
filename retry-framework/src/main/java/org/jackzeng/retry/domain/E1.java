package org.jackzeng.retry.domain;

/**
 * @author zengxijin created on 2017/8/27
 */
public enum E1 {

    PASS(1),
    REJECT(2);

    private int val;

    E1(int val){
        this.val = val;
    }
}
