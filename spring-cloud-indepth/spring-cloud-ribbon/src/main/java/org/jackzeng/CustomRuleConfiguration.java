package org.jackzeng;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by XijinZeng on 2017/5/3.
 */
public class CustomRuleConfiguration {

    @Autowired
    private IClientConfig clientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig clientConfig){
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig){
        return new RoundRobinRule();
    }

}
