package com.jack.design.pattern.proxy.staticproxy;

/**
 * @author xijin.zeng created on 2018/8/1
 */
public class RealSubject implements Subject {

    @Override
    public void action() {
        System.out.println(this.getClass().toString() + " action");
    }
}
