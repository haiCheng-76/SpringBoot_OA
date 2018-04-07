package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pageControl")
public class PageControl {
	@RequestMapping(value = "/topage")
	public ModelAndView topage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("date", new Date());
		return mav;
	}

	@RequestMapping(value = "/tomainpage.htm")
	public String toMainPage() {
		return "Main";
	}

	@RequestMapping(value = "/toCaringoList.htm")
	public String toCaringoList() {
		return "CarInfo/ListCarInfo";
	}

	@RequestMapping(value = "/toShowCar.htm")
	public ModelAndView toShowCar(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CarInfo/ShowCarInfo");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toEditCar.htm")
	public ModelAndView toEditCar(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("CarInfo/editCarInfo");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toaddCarinfo.htm")
	public String toaddCarinfo() {
		return "CarInfo/addCarinfo";
	}

	@RequestMapping(value = "/toEmployeePage.htm")
	public String toEmployeePage() {
		return "Employee/ListEmployees";
	}

	@RequestMapping(value = "/toaddEmployee.htm")
	public String toaddEmployee() {
		return "Employee/addEmployee";
	}

	@RequestMapping(value = "/toShowEmployee.htm")
	public ModelAndView toShowEmployee(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Employee/ShowEmployee");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toEditEmployee.htm")
	public ModelAndView toEditEmployee(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Employee/EditEmployees");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toDepartmentPage.htm")
	public String toDepartmentPage() {
		return "Department/ListDepartment";
	}

	@RequestMapping(value = "/toaddDepartment.htm")
	public String toaddDepartment() {
		return "Department/addDepartment";
	}

	@RequestMapping(value = "/toShowDepartment.htm")
	public ModelAndView toShowDepartment(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Department/ShowDepartment");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toEditDepartment.htm")
	public ModelAndView toEditDepartment(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Department/EditDepartment");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toFilePage.htm")
	public String toFilePage() {
		return "File/ListFile";
	}

	@RequestMapping(value = "/toDevicePage.htm")
	public String toDevicePage() {
		return "Device/ListDevice";
	}

	@RequestMapping(value = "/toaddDevice.htm")
	public String toaddDevice() {
		return "Device/addDevice";
	}

	@RequestMapping(value = "/toShowDevice.htm")
	public ModelAndView toShowDevice(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Device/ShowDevice");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toEditDevice.htm")
	public ModelAndView toEditDevice(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Device/EditDevice");
		mav.addObject("ID", ID);
		return mav;
	}

	@RequestMapping(value = "/toCarPage.htm")
	public String toCarPage() {
		return "CarInfo/ListCarInfo";
	}

	@RequestMapping(value = "/toaddFile")
	public String toaddFile() {
		return "File/addFile";
	}

	@RequestMapping(value = "/toeditFile")
	public ModelAndView toeditFile(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ID", ID);
		mav.setViewName("File/EditFile");
		return mav;
	}

	@RequestMapping(value = "/toshowFile")
	public ModelAndView toshowFile(String ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ID", ID);
		mav.setViewName("File/ShowFile");
		return mav;
	}

	@RequestMapping(value = "/toforgetpage")
	public String toforgetpage() {
		return "forgetPwd";
	}
}
