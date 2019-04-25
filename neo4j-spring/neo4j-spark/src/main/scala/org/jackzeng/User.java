package org.jackzeng;

import lombok.Data;

/**
 * @author xijin.zeng created on 2018/9/20
 */
@Data
public class User {
    private String id;
    private String name;
    private int age;

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
