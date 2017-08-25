package org.jackzeng;

import org.jackzeng.aop.query.impl.MyAysncTask;
import org.jackzeng.domain.RpcMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;

/**
 * @author zengxijin created on 2017/8/25
 */
@SpringBootApplication
@Import(MyConfig.class)
public class AppStartup {

    public static void main(String[] args) {
        SpringApplication.run(AppStartup.class,args);

    }
}
