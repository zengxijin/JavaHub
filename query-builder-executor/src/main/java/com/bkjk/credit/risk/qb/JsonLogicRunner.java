package com.bkjk.credit.risk.qb;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.jamsesso.jsonlogic.JsonLogic;
import io.github.jamsesso.jsonlogic.JsonLogicException;

import java.io.IOException;
import java.util.Map;

/**
 * @author zengxijin
 */
public class JsonLogicRunner {

    public static void main(String[] args) throws IOException, JsonLogicException {
        JsonLogic jsonLogic = new JsonLogic();

        String json = Resources.toString(Resources.getResource("json_logic.json"), Charsets.UTF_8);
        String jsonData = Resources.toString(Resources.getResource("data.json"), Charsets.UTF_8);
        System.out.println(json);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Map<String, Object> data = gson.fromJson(jsonData, Map.class);
        System.out.println(jsonLogic.apply(json, data));
    }
}
