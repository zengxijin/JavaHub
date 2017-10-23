package org.jackzeng.retry.domain;

/**
 * @author zengxijin created on 2017/8/27
 */
public enum E2 {

    PASS(2),
    REJECT(3);

    private int val;

    E2(int val){
        this.val = val;
    }

}
