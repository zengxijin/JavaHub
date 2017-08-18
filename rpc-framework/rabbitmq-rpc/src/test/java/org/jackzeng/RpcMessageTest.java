package org.jackzeng;

import org.jackzeng.domain.RpcMessage;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author zengxijin created on 2017/8/18
 */
public class RpcMessageTest {

    @Test
    public void test() throws Exception {
        RpcMessage<String> message = RpcMessage.<String>builder()
                .msgId(UUID.randomUUID().toString())
                .msgData("String Data")
                .createTime(LocalDateTime.now())
                .build();

        Assert.assertTrue(message.getMsgData().equals("String Data"));

        System.out.println(message);
    }
}
