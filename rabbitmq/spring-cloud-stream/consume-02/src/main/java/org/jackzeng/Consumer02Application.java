package org.jackzeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author xijin.zeng created on 2019/8/6
 */
@SpringBootApplication
@EnableBinding(CacheEventSink.class)
public class Consumer02Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer02Application.class, args);
    }

    @StreamListener(CacheEventSink.INPUT)
    public void consumeEvent(LogMessage log) {
        System.out.println("consume-02 message: " + log.getMessage());
    }
}