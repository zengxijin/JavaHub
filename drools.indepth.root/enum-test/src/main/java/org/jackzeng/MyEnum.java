//package org.jackzeng;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//
//import java.io.IOException;
//
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
//@JsonDeserialize(using = MyEnum.MyEnumDeserializer.class)
//public enum MyEnum {
//    Value1("Value1"),
//    Value2("Value2"),
//    Value3("Value2");
//
//    @JsonProperty("value")
//    private String value;
//
//    MyEnum(String value) {
//        this.value = value;
//    }
//
//    @JsonCreator
//    public static MyEnum fromValue(final JsonNode jsonNode) {
//
//        for (MyEnum type : MyEnum.values()) {
//            if (type.value.equals(jsonNode.get("value").asText())) {
//                return type;
//            }
//        }
//        return null;
//    }
//
//    public static class MyEnumDeserializer extends StdDeserializer<MyEnum> {
//        public MyEnumDeserializer() {
//            super(MyEnum.class);
//        }
//
//        @Override
//        public MyEnum deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
//            final JsonNode jsonNode = jp.readValueAsTree();
//            String key = jsonNode.get("key").asText();
//            String value = jsonNode.get("value").asText();
//
//            for (MyEnum me: MyEnum.values()) {
//                if (type.value.equals(jsonNode.get("value").asText())) {
//                    return type;
//                }
//            }
//            throw dc.mappingException("Cannot deserialize MyEnum from key " + key + " and value " + value);
//        }
//    }
//}