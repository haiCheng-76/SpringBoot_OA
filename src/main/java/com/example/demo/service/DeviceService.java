package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Device;

public interface DeviceService {
	boolean addDevice(Device device);

	boolean updateDevice(Device device);

	boolean deleteDevice(Device device);

	Device selectDeviceById(int id);

	List<Device> getallDevice();
}
