package com.jack.design.pattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author xijin.zeng created on 2018/8/1
 */
public class ClientCode {
    public static void main(String[] args) {
        Subject target = new RealSubject();
        InvocationHandler handler = new DynamicProxyHandler(target);
        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        subject.action();
    }
}
