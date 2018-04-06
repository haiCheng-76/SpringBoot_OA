package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CarInfoDao;
import com.example.demo.domain.CarInfo;
import com.example.demo.service.CarService;

public class CarServiceImpl implements CarService {
	@Autowired
	private CarInfoDao carInfoDao;

	@Override
	public boolean addCarInfo(CarInfo carInfo) {
		int addnum = carInfoDao.addCarInfo(carInfo);
		return addnum == 1 ? true : false;
	}

	@Override
	public boolean updateCarInfo(CarInfo carInfo) {
		int updatenum = carInfoDao.updateCarInfo(carInfo);
		return updatenum == 1 ? true : false;
	}

	@Override
	public boolean deleteCarInfo(CarInfo carInfo) {
		int deletenum = carInfoDao.deleteCarInfo(carInfo);
		return deletenum == 1 ? true : false;
	}

	@Override
	public CarInfo selectCarInfoById(int id) {
		return carInfoDao.selectCarInfoById(id);
	}

	@Override
	public List<CarInfo> getallCarInfo() {
		return carInfoDao.getallCarInfo();
	}

}
