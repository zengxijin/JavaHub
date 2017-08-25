package org.jackzeng.aop.service;

/**
 * @author zengxijin created on 2017/8/25
 */
public interface AsyncTask {
    void onRpcReturn(String id,Object result,Throwable t);
    void doSth();
}
