package org.jackzeng;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by XijinZeng on 2017/5/9.
 */
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
    private int years;

    private Employee(){}

    public Employee(String name, int age, int years) {
        this.name = name;
        this.age = age;
        this.years = years;
    }
}
