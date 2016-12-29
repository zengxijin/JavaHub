package com.jackzeng.orm.mappers;

import java.util.List;

import com.jackzeng.orm.domain.Employee;

public interface EmployeeMapper {
	List<Employee> findAllEmployees();
	Employee findEmployeeById(Integer id);
	void insertEmployee(Employee employee);
	void updateEmployee(Employee employee);
}
