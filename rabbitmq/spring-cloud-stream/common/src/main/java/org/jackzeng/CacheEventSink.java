package org.jackzeng;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xijin.zeng created on 2019/8/6
 * 消费者 配置
 */
public interface CacheEventSink {

    String INPUT = "cacheEvent";

    @Input(INPUT)
    SubscribableChannel inputCacheEvent();
}
