package org.jackzeng;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public class EntityWrapperNewTest {

    @Test
    public void testSerialize() throws JsonProcessingException {
        EntityWrapperNew entityWrapperNew = new EntityWrapperNew();
        entityWrapperNew.setStringField("StringValue");
        entityWrapperNew.setEnumField(LoanStatusNew.UNPAYED);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(entityWrapperNew);

        System.out.println(json);
    }

    @Test
    public void testDeserialize() throws IOException {
        String json = "{\"stringField\":\"StringValue\",\"enumField\":\"未结清\"}";
        ObjectMapper mapper = new ObjectMapper();

        EntityWrapperNew entityWrapperNew = mapper.readValue(json,EntityWrapperNew.class);
        System.out.println(entityWrapperNew.getStringField() + " " + entityWrapperNew.getEnumField());
    }
}
