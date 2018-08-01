package com.jack.design.pattern.proxy.staticproxy;

/**
 * @author xijin.zeng created on 2018/8/1
 */
public class ClientCode {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.action();
    }
}
