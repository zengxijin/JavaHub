package com.jack.design.pattern.proxy.staticproxy;

/**
 * @author xijin.zeng created on 2018/8/1
 */
public class Proxy implements Subject {

    private Subject delegateTarget;

    public Proxy(Subject delegateTarget) {
        this.delegateTarget = delegateTarget;
    }

    public void action() {
        System.out.println("invoke from Proxy");
        this.delegateTarget.action();
    }
}
