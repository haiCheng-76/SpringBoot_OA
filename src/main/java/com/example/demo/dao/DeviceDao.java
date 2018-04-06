package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Device;

@Mapper
public interface DeviceDao {
	int addDevice(Device device);

	int updateDevice(Device device);

	int deleteDevice(Device device);

	Device selectDeviceById(Integer id);

	List<Device> getallDevice();
}
