package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.CarInfo;

@Mapper
public interface CarInfoDao {
	int addCarInfo(CarInfo carInfo);

	int updateCarInfo(CarInfo carInfo);

	int deleteCarInfo(CarInfo carInfo);

	CarInfo selectCarInfoById(Integer id);

	List<CarInfo> getallCarInfo();
}
