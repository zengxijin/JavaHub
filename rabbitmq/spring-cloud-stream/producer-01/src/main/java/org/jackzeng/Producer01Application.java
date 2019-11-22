package org.jackzeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xijin.zeng created on 2019/8/6
 */
@SpringBootApplication
public class Producer01Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer01Application.class, args);

        System.out.println("test out");
    }

}
