package org.jackzeng.truck;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author zengxj
 * @create 2017/11/30
 * 对于从mongoexport出来的数据，由于使用spring-data的工具存储数据，因此数据中存储了一些额外的信息
 * 做反序列化的时候，可以直接使用mongoTemplate，这样就可以省去很多编写Jackson特定field的处理
 * 不过每次使用mongoTemplate做反序列化的时候，都会连接到对应的数据库，如果对应的collection不存在，会创建对应的collection
 */
public class MongoOps {
    public void test() throws IOException {
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new Mongo("192.168.56.101", 27017), "test");

        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory, new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper());
        converter.setCustomConversions(new CustomConversions(
                Arrays.asList(
                        //自定义的序列化Converter加在这里
                        //String->LocalDateTime
                        new Converter<String, LocalDateTime>() {
                            @Override
                            public LocalDateTime convert(String s) {
                                return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            }
                        }
                )
        ));
        converter.afterPropertiesSet();
        MongoTemplate templateNew = new MongoTemplate(mongoDbFactory, converter);

        Path path = Paths.get("D:\\juxinli_detail.txt");
        List<String> dt = Files.readAllLines(path);
        StringBuilder builder = new StringBuilder();
        dt.forEach(s->builder.append(s));

        BasicDBObject dtDBObject = BasicDBObject.parse(builder.toString());
//        DetailReportResponse detailReportResponse =  templateNew.getConverter().read(DetailReportResponse.class, dtDBObject);
//
//        ObjectMapper mapper = new ObjectMapper();
//        System.out.println(
//                mapper.writeValueAsString(detailReportResponse)
//        );
    }
}
