package org.jackzeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xijin.zeng created on 2019/8/6
 */
@Service
@EnableBinding({CacheEventSource.class})
public class ProduceService {

    @Autowired
    private MessageChannel cacheEvent;

//    public void runSend() {
//        System.out.println("starting sending");
//
//        int i = 0;
//        while (i < 100) {
//            produceNewEvent(new LogMessage(String.valueOf(i)));
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i++;
//        }
//    }

    public void produceNewEvent(LogMessage message) {
        System.out.println("send message of:" + message.getMessage());

        Message<LogMessage> sendMsg = MessageBuilder.withPayload(message).build();
        cacheEvent.send(sendMsg);
    }
}
