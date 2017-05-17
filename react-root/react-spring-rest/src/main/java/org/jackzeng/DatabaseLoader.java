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
        this.repository.save(new Employee("jack",31,35));
        this.repository.save(new Employee("mike",32,36));
        this.repository.save(new Employee("jerry",33,37));
        this.repository.save(new Employee("susi",34,38));
    }
}
