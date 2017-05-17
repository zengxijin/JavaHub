package org.jackzeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by XijinZeng on 2017/5/9.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Jack","Zeng","Teacher"));
        this.repository.save(new Employee("Kobe","Byrant","Player"));
        this.repository.save(new Employee("Sansa","Start","King"));
        this.repository.save(new Employee("Snow","John","Night Wather"));
    }
}
