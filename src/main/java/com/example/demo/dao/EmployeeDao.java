package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Employee;

@Mapper
public interface EmployeeDao {
	int addEmployee(Employee e);

	int deleteEmployee(Employee e);

	int updateEmployee(Employee e);

	Employee selectEmployeeById(Employee e);

	List<Employee> getallEmployee();

	int getuserByUPR(Employee e);

	int forgetPassword(Employee e);
}
