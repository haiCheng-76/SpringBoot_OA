package com.example.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employeeControl")
public class EmployeeControl {
	private Logger log = Logger.getLogger(EmployeeControl.class);
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping()
	public String isUser(@ModelAttribute("Employee") Employee emp) {
		String str = "";
		boolean hasuser = false;
		try {
			hasuser = employeeService.getuserByUPR(emp.getEmployee_account(), emp.getPassword(), emp.getRole());
		} catch (Exception e) {
			log.info("判断用户登陆失败时，网络出错！");
			e.printStackTrace();
		}
		if (hasuser) {
			str = "success";
		} else {
			str = "error";
		}
		return str;
	}

	@GetMapping()
	public String forgetPassword(@ModelAttribute("Employee") Employee emp) {
		String page = "";
		boolean isupdate = employeeService.updatePassword(emp);
		if (isupdate) {
			page = "";
		} else {
			page = "";
		}
		return page;
	}

	@DeleteMapping("{ID}")
	public String deleteEmployee(@PathVariable("{ID}")Integer ID) {
		Employee e = new Employee();
		e.setEmployee_id(ID);
		boolean isdelete = false;
		try {
			isdelete = employeeService.deleteEmployee(e);
			log.info("删除用户成功");
		} catch (Exception e1) {
			log.info("删除用户时，网络出错！");
			e1.printStackTrace();
		}
		if (isdelete) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	@PostMapping()
	public String addEmployee(@ModelAttribute("Employee")Employee e) {
		boolean isadd = false;
		try {
			isadd = employeeService.addEmployee(e);
			log.info("添加用户成功");
		} catch (Exception e1) {
			log.info("添加用户时，网络出错！");
			e1.printStackTrace();
		}
		if (isadd) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	@GetMapping()
	public List<Employee> getallEmoloyee() {
		List<Employee> listEmployee = null;
		try {
			listEmployee = employeeService.getallEmployee();
			log.info("获取所有员工信息成功");
		} catch (Exception e) {
			log.info("获取所有员工信息时网络出错！");
			e.printStackTrace();
		}
		return listEmployee;
	}

	@GetMapping("{ID}")
	public Employee getEmployeeById(@PathVariable("{ID}")Integer id) {
		Employee resp = new Employee();
		try {
			resp = employeeService.selectEmployeeById(id);
		} catch (Exception e) {
			log.info("获取编号为" + id + "的员工信息时出现异常，请稍后重试");
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping()
	public String updateEmployee(@ModelAttribute("Employee")Employee e) {
		boolean isupdate = false;
		try {
			isupdate = employeeService.updateEmployee(e);
		} catch (Exception e1) {
			log.info("修改员工信息时出现异常，请稍后重试");
			e1.printStackTrace();
		}
		if (isupdate) {
			return "SUCCESS";
		}
		return "ERROR";
	}
}
