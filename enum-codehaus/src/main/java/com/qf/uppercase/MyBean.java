package com.qf.uppercase;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by XijinZeng on 2017/5/17.
 */
public class MyBean {

    private String UpperField;

    public String getUpperField() {
        return UpperField;
    }

    public void setUpperField(String upperField) {
        UpperField = upperField;
    }

    public static void main(String[] args) throws IOException {
        MyBean bean = new MyBean();
        bean.setUpperField("HI");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bean);
        System.out.println(json);

    }
}
