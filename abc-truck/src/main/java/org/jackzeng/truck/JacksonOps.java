package org.jackzeng.truck;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zengxj
 * @create 2017/11/30
 */
public class JacksonOps {

    public void gsonTest() throws Exception {
        String json = getJson("D:\\juxinli_detail.txt");
        //Gson gson = GsonUtil.getGson();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        module.addDeserializer(Long.class, new LongDeserializer());
        module.addDeserializer(BigDecimal.class, new BigDecimalDeserializer());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        mapper.registerModule(module);

        DetailReportResponse response = mapper.readValue(json, DetailReportResponse.class);
    }


    //something exported from mongo
    //{"_id":{"$oid":"59f74c81496eb84f18122297"},"createTime":{"$date":"2017-10-30T15:59:54.692Z"},"updateTime":{"$date":"2017-10-30T15:59:54.692Z"}}

    @Data
    class DetailReportResponse {
        private LocalDateTime createTime;
        private Long count;
        private BigDecimal money;
        private String string;
    }

    class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            String key = "$date";
            String dateTimeStr = jp.getText().trim();
            JsonNode node = jp.getCodec().readTree(jp);
            if (node != null) {
                JsonNode dateNode = node.get(key);
                if (dateNode != null && StringUtils.isNotEmpty(dateNode.asText())) {
                    dateTimeStr = dateNode.asText();
                }
            }

            int end = dateTimeStr.lastIndexOf(46);
            dateTimeStr = dateTimeStr.substring(0, end < 0 ? dateTimeStr.length() : end);
            return dateTimeStr.indexOf(84) < 0 ?
                    LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    : LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        }
    }

    class LongDeserializer extends JsonDeserializer<Long> {
        @Override
        public Long deserialize(com.fasterxml.jackson.core.JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            String key = "$numberLong";
            JsonNode node = jp.getCodec().readTree(jp);
            JsonNode longNode = node.get(key);
            if (longNode != null) {
                String longStr = longNode.asText();
                if (StringUtils.isNotEmpty(longStr)) {
                    return Long.valueOf(longStr);
                }
            }
            return null;
        }
    }

    class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {
        @Override
        public BigDecimal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            String key = "$numberLong";
            JsonNode node = jp.getCodec().readTree(jp);
            JsonNode deciNode = node.get(key);
            if (deciNode != null) {
                String str = deciNode.asText();
                if (StringUtils.isNotEmpty(str)) {
                    return new BigDecimal(str);
                }
            }
            return null;
        }
    }

    private String getJson(String path) throws IOException {
        Path p = Paths.get(path);
        //just first line
        try (BufferedReader reader = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
            return reader.readLine();
        }
    }
}
