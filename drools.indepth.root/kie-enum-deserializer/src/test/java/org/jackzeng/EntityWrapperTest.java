package org.jackzeng;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public class EntityWrapperTest {

    @Test
    public void testSerialize() throws JsonProcessingException {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.setStringField("StringValue");
        wrapper.setEnumField(LoanStatus.PAYED);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(wrapper);
        System.out.println(jsonStr);
    }

    @Test
    public void testDeserialize() throws IOException {
        String jsonStr = "{\"stringField\":\"StringValue\",\"enumField\":\"PAYED\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        EntityWrapper wrapper = objectMapper.readValue(jsonStr,EntityWrapper.class);
        System.out.println(wrapper.getStringField() + " " + wrapper.getEnumField());
    }
}
