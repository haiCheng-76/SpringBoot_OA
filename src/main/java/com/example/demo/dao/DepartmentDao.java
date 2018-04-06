package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Department;

@Mapper
public interface DepartmentDao {
	int addDepartment(Department department);

	int updateDepartment(Department department);

	int deleteDepartment(Department department);

	Department selectDepartmentById(Integer id);

	List<Department> getallDepartment();
}
