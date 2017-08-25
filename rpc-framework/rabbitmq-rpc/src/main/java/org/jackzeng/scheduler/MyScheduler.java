package org.jackzeng.scheduler;

import org.jackzeng.aop.query.impl.MyAysncTask;
import org.jackzeng.aop.service.AsyncTask;
import org.jackzeng.domain.RpcMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zengxijin created on 2017/8/25
 */
@Component
public class MyScheduler {

    @Autowired
    AsyncTask task;

    @Scheduled(cron = "0/10 0 * * * ?")
    public void scheduler(){

        RpcMessage<String> message = RpcMessage.<String>builder()
                .msgId("aa")
                .msgData("ss")
                .createTime(LocalDateTime.now())
                .build();
        Throwable t = new Throwable("not good");

        task.doSth();
        task.onRpcReturn("jack",message,t);
    }
}
