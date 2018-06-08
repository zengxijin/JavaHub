package org.jackzeng;

import com.google.common.collect.Lists;
import org.jackzeng.domain.node.Phone;
import org.jackzeng.domain.node.User;
import org.jackzeng.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Neo4jSpringDataTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userOwnPhoneTest() throws Exception {
        Phone phone = new Phone();
        phone.setPhoneNo("13800123456");

        User user = new User();
        user.setName("Jack");
        user.setPhones(Lists.newArrayList(phone));

        userRepository.save(user);
    }
}
