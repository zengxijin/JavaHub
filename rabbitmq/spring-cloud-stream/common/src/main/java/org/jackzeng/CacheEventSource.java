package org.jackzeng;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author xijin.zeng created on 2019/8/6
 */
public interface CacheEventSource {
    String OUTPUT = "cacheEvent";

    @Output(OUTPUT)
    MessageChannel outputCacheEvent();
}
