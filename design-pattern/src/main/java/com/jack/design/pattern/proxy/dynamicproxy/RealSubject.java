package com.jack.design.pattern.proxy.dynamicproxy;

/**
 * @author xijin.zeng created on 2018/8/1
 */
public class RealSubject implements Subject {

    public void action() {
        System.out.println(this.getClass().getName() + " action");
    }
}
