package org.jackzeng.aop.monitor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zengxijin created on 2017/8/25
 */
@Aspect
@Component
public class AopMonitor {

    @Pointcut("execution(* org.jackzeng.aop.query.*.onRpcReturn(..))")
    public void point(){}

    @After("execution(* onRpcReturn(java.lang.String,java.lang.Object,java.lang.Throwable))" +
            " && args(id,result,t)")
    public void notifyTask(String id, Object result, Throwable t) {
        System.out.println("after onRpcReturn");
        System.out.println(id);
        System.out.println(result);
        System.out.println(t);
    }

}
