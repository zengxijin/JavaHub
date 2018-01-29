package org.jackzeng.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * @author zengxj
 * @create 2018/1/29
 */
@Data
@Builder
public class Person {
    private String name;
    private int age;

    private Address address;
}
