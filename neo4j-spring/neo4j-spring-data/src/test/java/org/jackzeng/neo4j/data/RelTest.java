package org.jackzeng.neo4j.data;

import org.jackzeng.neo4j.data.domain.*;
import org.jackzeng.neo4j.data.repository.CallRepository;
import org.jackzeng.neo4j.data.repository.OwnRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author xijin.zeng created on 2018/5/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelTest {

    @Autowired
    private OwnRepository ownRepository;

    @Test
    public void relAddTest() throws Exception {
        Person person = Person.builder()
                .ssn("123")
                .phone("123")
                .name("456")
                .build();

        Phone phone = Phone.builder()
                .phoneNo("123")
                .build();

        Own own = Own.builder()
                .person(person)
                .phone(phone)
                .pro("relPro")
                .build();

        ownRepository.save(own);
    }

    /**
     * 利用RelationshipEntity的@StartNode和@EndNode的机制，想实现动态的起始节点和结束节点都是动态的类型
     * 这个时候在sessionFactory在创建的时候会启动relationship的schema，因为schema的创建找不到绑定类型，因此会报错
     * 我们可以给一个设计一个基本类型，然后让其他动态的节点类型都基于基类，这样可以实现动态的开始和结束节点
     * 但是这样的继承关系在体现在Neo4j节点的标签中，因为neo4j-spring-data在持久化的时候就将继承关系体现为节点的多标签
     */
    @Autowired
    private CallRepository callRepository;

    @Test
    public void addGenericRel() throws Exception {
        Phone phone1 = Phone.builder()
                .phoneNo("456")
                .build();

        Phone phone2 = Phone.builder()
                .phoneNo("789")
                .build();

        Call call = Call.<Phone, Phone>builder()
                .startNode(phone1)
                .endNode(phone2)
                .callTime(LocalDateTime.now().toString())
                .build();

        callRepository.save(call);
    }
}
