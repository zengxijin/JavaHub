package org.jackzeng;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XijinZeng on 2017/5/11.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        /*Wrapper w = new Wrapper();
        w.setName("zeng");
        w.setUnit(Unit.A1);

        String s = JSONObject.toJSONString(w);
        System.out.println(s);

        String json = "{\"name\":\"zeng\",\"unit\":\"我是A1\"}";
        Wrapper p = JSONObject.parseObject(json,Wrapper.class);
        System.out.println(p.getUnit());*/
        ObjectMapper mapper = new ObjectMapper();
        Map<HelloEnum,String> map = new HashMap<HelloEnum, String>();
        map.put(HelloEnum.HELLO,"1");
        map.put(HelloEnum.WORLD,"2");

        System.out.println(mapper.writeValueAsString(map));

        Wrapper wp = new Wrapper();
        wp.setName("Hi");
        wp.setHello(HelloEnum.HELLO);
        System.out.println(mapper.writeValueAsString(wp));

        String djson = "{\"hello\":\"h\",\"name\":\"Hi\"}";
        Wrapper wp2 = mapper.readValue(djson, Wrapper.class );
        System.out.println(wp2.getHello());

        //objectMapper.readValue(objectMapper.writeValueAsString(testMap), new TypeReference<Map<HelloEnum,String>>()
    }
}
