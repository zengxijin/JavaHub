package com.jackzeng.orm.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jackzeng.orm.domain.Employee;
import com.jackzeng.orm.mappers.EmployeeMapper;
import com.jackzeng.orm.util.CustomSqlSessionFactory;

public class EmployeeService {
	
	public List<Employee> findAllEmployees(){
		SqlSession session = CustomSqlSessionFactory.getSqlSession();
		try{
			EmployeeMapper employeeMapper =  session.getMapper(EmployeeMapper.class);
			return employeeMapper.findAllEmployees();
		}
		finally{
			session.close();
		}
	}
	
	public Employee findEmployeeById(Integer id){
		SqlSession session = CustomSqlSessionFactory.getSqlSession();
		try{
			EmployeeMapper employeeMapper =  session.getMapper(EmployeeMapper.class);
			return employeeMapper.findEmployeeById(id);
		}
		finally{
			session.close();
		}
	}
	
	public void insertEmployee(Employee employee){
		SqlSession session = CustomSqlSessionFactory.getSqlSession();
		try{
			EmployeeMapper employeeMapper =  session.getMapper(EmployeeMapper.class);
			employeeMapper.insertEmployee(employee);
		}
		finally{
			session.close();
		}
	}
	
	public void updateEmployee(Employee employee){
		SqlSession session = CustomSqlSessionFactory.getSqlSession();
		try{
			EmployeeMapper employeeMapper =  session.getMapper(EmployeeMapper.class);
			employeeMapper.updateEmployee(employee);
		}
		finally{
			session.close();
		}
	}
}
