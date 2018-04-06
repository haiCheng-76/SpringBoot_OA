package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.CarInfo;

public interface CarService {
	boolean addCarInfo(CarInfo carInfo);

	boolean updateCarInfo(CarInfo carInfo);

	boolean deleteCarInfo(CarInfo carInfo);

	CarInfo selectCarInfoById(int id);

	List<CarInfo> getallCarInfo();
}
