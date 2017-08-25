package org.jackzeng.aop.query;

import org.jackzeng.aop.service.AsyncTask;

/**
 * @author zengxijin created on 2017/8/25
 */
public class AsyncTaskBase implements AsyncTask {


    public void onRpcReturn(String id, Object result, Throwable t) {
        System.out.println(
                this.getClass().getCanonicalName() + " onRpcReturn"
                + id + " " + result + " " + t
        );
    }

    public void doSth(){
        System.out.println("I am doing sth");
    }
}
