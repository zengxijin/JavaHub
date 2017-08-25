package org.jackzeng;

import org.jackzeng.aop.query.impl.MyAysncTask;
import org.jackzeng.domain.RpcMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author zengxijin created on 2017/8/25
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.aop.auto=true",classes = AppStartup.class)
public class SpringTest {


    MyAysncTask task = new MyAysncTask();

    @Test
    public void test(){
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
