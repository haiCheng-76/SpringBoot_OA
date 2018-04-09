package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.CarInfo;
import com.example.demo.service.CarService;

@RestController
@RequestMapping(value = "/carInfoControl")
public class CarInfoControl {
	@Autowired
	private CarService carService;

	@GetMapping()
	public List<CarInfo> getAllCarIfo() {
		List<CarInfo> allCarInfo = null;
		try {
			allCarInfo = carService.getallCarInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCarInfo;
	}

	@PostMapping
	public String addCarIfo(@ModelAttribute("CarInfo") CarInfo carInfo) {
		boolean isadded = false;
		try {
			isadded = carService.addCarInfo(carInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isadded) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	@GetMapping(value="{id}")
	public CarInfo getCarinfoById(@PathVariable("id") Integer ID) {
		CarInfo carInfo = new CarInfo();
		try {
			carInfo = carService.selectCarInfoById(ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carInfo;
	}

	@PutMapping
	public String updateCarinfo(@ModelAttribute("CarInfo")CarInfo carInfo) {
		boolean isupdate = false;
		try {
			isupdate = carService.updateCarInfo(carInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isupdate) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	@DeleteMapping("{ID}")
	public String deleteCarinfo(Integer ID) {
		boolean isdelete = false;
		CarInfo carInfo = new CarInfo();
		carInfo.setCarid(ID);
		try {
			isdelete = carService.deleteCarInfo(carInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isdelete) {
			return "SUCCESS";
		}
		return "ERROR";
	}
}
