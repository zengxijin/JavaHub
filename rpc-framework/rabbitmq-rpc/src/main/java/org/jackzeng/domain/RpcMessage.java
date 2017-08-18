package org.jackzeng.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zengxijin created on 2017/08/18
 */
@Data
@Builder
public class RpcMessage<T> {
    private String msgId;
    private T msgData;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
