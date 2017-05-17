package com.qf;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by XijinZeng on 2017/5/12.
 */
public class WrapperTest {
    @Test
    public void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Wrapper wrapper = new Wrapper();
        wrapper.setStringField("String");
        wrapper.setEnumField(LoanStatus.UNPAYED);

        String json = mapper.writeValueAsString(wrapper);
        System.out.println(json);

        String jsonInput = "{\"stringField\":\"String\",\"enumField\":\"未结清\"}";
        Wrapper wrapperNew = mapper.readValue(jsonInput,Wrapper.class);
        System.out.println(wrapperNew.getEnumField() + " " + wrapperNew.getStringField());
    }
}
