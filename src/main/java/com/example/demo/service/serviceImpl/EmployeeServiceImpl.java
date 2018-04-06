package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean addEmployee(Employee e) {
		int addnumber = employeeDao.addEmployee(e);
		return addnumber == 1 ? true : false;
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		int deletenumber = employeeDao.deleteEmployee(e);
		return deletenumber == 1 ? true : false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		int updatenumber = employeeDao.updateEmployee(e);
		return updatenumber == 1 ? true : false;
	}

	@Override
	public Employee selectEmployeeById(int id) {
		Employee e = new Employee();
		e.setEmployee_id(id);
		Employee employee = employeeDao.selectEmployeeById(e);
		return employee;
	}

	@Override
	public List<Employee> getallEmployee() {
		List<Employee> allEmployee = employeeDao.getallEmployee();
		return allEmployee;
	}

	@Override
	public boolean getuserByUPR(String account, String password, int role) {
		Employee e = new Employee();
		e.setEmployee_account(account);
		e.setPassword(password);
		e.setRole(role);
		int hasusernum = employeeDao.getuserByUPR(e);
		return hasusernum == 1 ? true : false;
	}

	@Override
	public boolean updatePassword(Employee e) {
		int updatenumber = employeeDao.forgetPassword(e);
		return updatenumber == 1 ? true : false;
	}

}
