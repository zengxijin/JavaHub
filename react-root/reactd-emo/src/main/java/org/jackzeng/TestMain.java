package org.jackzeng;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

/**
 * Created by XijinZeng on 2017/5/10.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        String json = "\"未结清\"";
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader(LoanStatus.class);
        LoanStatus status = reader.with(DeserializationFeature.READ_ENUMS_USING_TO_STRING).readValue(json);
        System.out.println(status);  // NOT_READY
        //String j1 = JSONObject.toJSONString();
        //System.out.println(j1);
        //JSONObject object = JSON.
    }
}
