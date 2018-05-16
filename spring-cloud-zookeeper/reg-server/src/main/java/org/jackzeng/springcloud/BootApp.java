package org.jackzeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xijin.zeng created on 2018/5/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BootApp {

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }
}
