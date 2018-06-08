package org.jackzeng;

import org.jackzeng.domain.node.Car;
import org.jackzeng.domain.node.Customer;
import org.jackzeng.domain.node.Phone;
import org.jackzeng.domain.node.User;
import org.jackzeng.domain.rel.Have;
import org.jackzeng.repository.HaveRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HaveTest {

    @Autowired
    private HaveRepository haveRepository;

    @Test
    public void customerHaveCarTest() throws Exception {
        Customer customer = new Customer();
        customer.setName("Tom");
        Car car = new Car();
        car.setBrand("BMW");

        Have have = new Have();
        have.setCustomer(customer);
        have.setCar(car);
        have.setCreateTime(LocalDateTime.now().toString());

        haveRepository.save(have);
    }
}
