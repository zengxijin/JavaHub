package org.jackzeng.truck;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zengxj
 * @create 2017/12/4
 */
public class GsonOps {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String MONGO_UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static DateTimeFormatter mongo_formatter = DateTimeFormatter.ofPattern(MONGO_UTC_FORMAT);
    private static DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static Gson ETLGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
        @Override
        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.format(formatter));
        }
    }).registerTypeAdapter(Long.class, new BsonLongTypeAdapter())
            .registerTypeAdapter(long.class, new BsonLongTypeAdapter())
            .registerTypeAdapter(LocalDateTime.class, new BsonDateTimeTypeAdapter())
            .registerTypeAdapter(LocalDate.class, new BsonDateTypeAdapter())
            .registerTypeAdapter(BigDecimal.class, new BsonBigDecimalTypeAdapter())
            .registerTypeAdapter(Double.class, new BsonDoubleTypeAdapter())
            .create();


    private static Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
        @Override
        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.format(formatter));
        }
    }).registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.format(formatter));
        }
    }).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString(), formatter);
        }
    }).registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }
    }).create();

    //支持对同一类型的字段多种形式的值做反序列化时的适配
    private static class BsonBigDecimalTypeAdapter extends TypeAdapter<BigDecimal> {
        private String type = "$numberLong";

        @Override
        public void write(JsonWriter out, BigDecimal value) throws IOException {
            out.value(value == null ? "0" : value.toString());
        }

        @Override
        public BigDecimal read(JsonReader in) throws IOException {
            if (in.peek().equals(JsonToken.NUMBER)) {
                return new BigDecimal(in.nextString());
            }

            BigDecimal value = null;

            in.beginObject();
            String nextName = in.nextName();
            String nextString = in.nextString();
            if (type.equals(nextName)) {
                value = new BigDecimal(nextString);
            }
            in.endObject();

            return value;
        }
    }

    private static class BsonLongTypeAdapter extends TypeAdapter<Long> {
        private String type = "$numberLong";

        @Override
        public void write(JsonWriter out, Long value) throws IOException {
            out.value(value == null ? "0" : value.toString());
        }

        @Override
        public Long read(JsonReader in) throws IOException {
            if (in.peek().equals(JsonToken.NUMBER)) {
                String val = in.nextString();
                //TODO:(zengxj) for test old jar
                if (val.contains(".")) {
                    return Math.round(Double.valueOf(val));
                } else {
                    return Long.valueOf(val);
                }
            }

            in.beginObject();
            Long value = null;
            if (type.equals(in.nextName())) {
                value = Long.valueOf(in.nextString());
            }
            in.endObject();

            return value;
        }
    }

    private static class BsonDoubleTypeAdapter extends TypeAdapter<Double> {
        private String type = "$numberLong";

        @Override
        public void write(JsonWriter out, Double value) throws IOException {
            out.value(value == null ? "0" : value.toString());
        }

        @Override
        public Double read(JsonReader in) throws IOException {
            if (in.peek().equals(JsonToken.NUMBER)) {
                return in.nextDouble();
            }

            if (in.peek().equals(JsonToken.STRING)) {
                return Double.valueOf(in.nextString());
            }

            in.beginObject();
            Double value = null;
            if (type.equals(in.nextName())) {
                value = Double.valueOf(in.nextString());
            }
            in.endObject();

            return value;
        }
    }

    private static class BsonDateTimeTypeAdapter extends TypeAdapter<LocalDateTime> {
        private String type = "$date";

        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(value.format(DateTimeFormatter.ISO_DATE_TIME));
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            if (in.peek().equals(JsonToken.STRING)) {
                return LocalDateTime.parse(in.nextString(), localDateTimeFormatter);
            }

            in.beginObject();
            LocalDateTime value = null;
            if (type.equals(in.nextName())) {
                value = LocalDateTime.parse(in.nextString().substring(0, 19) + 'Z', DateTimeFormatter.ISO_DATE_TIME);
            }
            in.endObject();
            return value;
        }
    }

    private static class BsonDateTypeAdapter extends TypeAdapter<LocalDate> {
        private String type = "$date";

        @Override
        public void write(JsonWriter out, LocalDate value) throws IOException {
            out.value(value.format(DateTimeFormatter.ISO_DATE));
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            in.beginObject();
            LocalDate value = null;
            if (type.equals(in.nextName())) {
                value = LocalDate.parse(in.nextString().substring(0, 10) , DateTimeFormatter.ISO_DATE);
            }
            in.endObject();

            return value;
        }
    }

    public static Gson getGson() {
        return gson;
    }

    public static Gson getETLGson() {
        return ETLGson;
    }
}
