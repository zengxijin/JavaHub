package org.jackzeng.flink;

import org.apache.flink.api.common.serialization.AbstractDeserializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author xijin.zeng created on 2018/12/20
 *
 */
/**
 * 继承AbstractDeserializationSchema抽象类，用于自定义反序列化操作
 */
public class RuleResultSchema extends AbstractDeserializationSchema<RuleResult> {
    // for json string deserialize
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public RuleResult deserialize(byte[] message) throws IOException {
        return mapper.readValue(message, RuleResult.class);
    }
}
