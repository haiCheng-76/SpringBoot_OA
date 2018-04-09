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

import com.example.demo.domain.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping(value = "/departmentControl")
public class DepartmentControl {
	private Logger log = Logger.getLogger(DepartmentControl.class);
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getAllDepartment")
	public List<Department> getAllDepartment() {
		List<Department> listDepartment = null;
		try {
			listDepartment = departmentService.getallDepartment();
			log.info("请求部门相关信息成功");
		} catch (Exception e) {
			log.info("请求部门相关信息失败");
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	@PostMapping("/addDepartment")
	public String addDepartment(@ModelAttribute("Department") Department d) {
		boolean isadded = false;
		try {
			isadded = departmentService.addDepartment(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isadded) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	
	@GetMapping(value="/getDepartmentById/{ID}")
	public Department getDepartmentById(@PathVariable("ID")Integer ID) {
		Department department = new Department();
		try {
			department = departmentService.selectDepartmentById(ID);
		} catch (Exception e) {
			log.info("请求部门信息时出现异常，请稍后重试");
			e.printStackTrace();
		}
		return department;
	}

	@PutMapping("/updateDepartment")
	public String updateDepartment(@ModelAttribute("Department") Department d) {
		boolean isupdate = false;
		try {
			isupdate = departmentService.updateDepartment(d);
		} catch (Exception e) {
			log.info("修改部门信息时，出现异常，请稍后重试");
			e.printStackTrace();
		}
		if (isupdate) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	@DeleteMapping(value="/deleteDepartment/{ID}")
	public String deleteDepartment(@PathVariable("ID") Integer ID) {
		Department d = new Department();
		d.setDepartmentid(ID);
		boolean isdelete = false;
		try {
			isdelete = departmentService.deleteDepartment(d);
		} catch (Exception e) {
			log.info("删除部门信息时，出现异常");
			e.printStackTrace();
		}
		if (isdelete) {
			return "SUCCESS";
		}
		return "ERROR";
	}
}
