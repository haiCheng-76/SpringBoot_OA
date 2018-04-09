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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "/employeeControl")
public class EmployeeControl {
	private Logger log = Logger.getLogger(EmployeeControl.class);
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/isUser")
	public String isUser(@RequestParam("account") String account,@RequestParam("Password")String Password,@RequestParam("Role") Integer Role) {
		String str = "";
		boolean hasuser = false;
		try {
			hasuser = employeeService.getuserByUPR(account,Password,Role);
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



	@DeleteMapping("/deleteEmployee/{ID}")
	public String deleteEmployee(@RequestParam("ID")Integer ID) {
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

	@PostMapping(value="/addEmployee")
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

	@GetMapping(value="/getallEmoloyee")
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

	@GetMapping("/getEmployeeById/{ID}")
	public Employee getEmployeeById(@PathVariable("ID")Integer id) {
		Employee resp = new Employee();
		try {
			resp = employeeService.selectEmployeeById(id);
		} catch (Exception e) {
			log.info("获取编号为" + id + "的员工信息时出现异常，请稍后重试");
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping(value="/updateEmployee")
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
