package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.domain.Department;
import com.example.demo.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public boolean addDepartment(Department department) {
		int addnum = departmentDao.addDepartment(department);
		return addnum == 1 ? true : false;
	}

	@Override
	public boolean updateDepartment(Department department) {
		int updatenum = departmentDao.updateDepartment(department);
		return updatenum == 1 ? true : false;
	}

	@Override
	public boolean deleteDepartment(Department department) {
		int deletenum = departmentDao.deleteDepartment(department);
		return deletenum == 1 ? true : false;
	}

	@Override
	public Department selectDepartmentById(int id) {
		return departmentDao.selectDepartmentById(id);
	}

	@Override
	public List<Department> getallDepartment() {
		return departmentDao.getallDepartment();
	}

}
