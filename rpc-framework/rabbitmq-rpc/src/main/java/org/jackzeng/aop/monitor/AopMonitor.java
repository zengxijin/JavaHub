package org.jackzeng.aop.monitor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zengxijin created on 2017/8/25
 */
@Aspect
@Component
public class AopMonitor {

    @After("execution(* org.jackzeng.aop.query.impl.*.onRpcReturn(java.lang.String,java.lang.Object,java.lang.Throwable))" +
            " && args(id,result,t)")
    public void notifyTask(String id, Object result, Throwable t){
        System.out.println("after onRpcReturn");
        System.out.println(id);
        System.out.println(result);
        System.out.println(t);
    }

    @Before("execution(* org.jackzeng.*.doSth())")
    public void beforeRun(){
        System.out.println("check dosth invoked");
    }

}
