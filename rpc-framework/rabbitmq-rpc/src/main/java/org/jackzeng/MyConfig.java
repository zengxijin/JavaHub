package org.jackzeng;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zengxijin created on 2017/8/25
 */
@Configuration
@EnableScheduling
//@EnableAspectJAutoProxy
@ComponentScan({"org.jackzeng.*"})
public class MyConfig {
}
