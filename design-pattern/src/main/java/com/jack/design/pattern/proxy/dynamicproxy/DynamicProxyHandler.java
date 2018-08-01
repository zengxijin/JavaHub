package com.jack.design.pattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xijin.zeng created on 2018/8/1
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object delegateTarget;

    public DynamicProxyHandler(Object delegateTarget) {
        this.delegateTarget = delegateTarget;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before DynamicProxy invoke");

        method.invoke(delegateTarget, args);

        System.out.println("after DynamicProxy invoke");

        return null;
    }
}
