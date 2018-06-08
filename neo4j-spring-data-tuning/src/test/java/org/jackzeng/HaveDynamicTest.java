package org.jackzeng;

import org.jackzeng.domain.node.Car;
import org.jackzeng.domain.node.Customer;
import org.jackzeng.domain.rel.HaveDynamic;
import org.jackzeng.repository.HaveDynamicRepository;
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
public class HaveDynamicTest {

    @Autowired
    private HaveDynamicRepository haveDynamicRepository;

    @Test
    public void dynamicTest() throws Exception {
        Customer customer = new Customer();
        customer.setName("John");
        Car car = new Car();
        car.setBrand("Benz");

        HaveDynamic<Customer, Car> haveDynamic = new HaveDynamic<>();
        haveDynamic.setCreateTime(LocalDateTime.now().toString());
        haveDynamic.setStartNode(customer);
        haveDynamic.setEndNode(car);

        haveDynamicRepository.save(haveDynamic);

    }
}
