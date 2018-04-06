package com.example.demo.domain;

import java.io.Serializable;

public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375886108215209620L;
	private int deviceid;
	private String devicename;
	private double deviceprice;
	private int devicenumber;
	private String manufacture;
	public int getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public double getDeviceprice() {
		return deviceprice;
	}
	public void setDeviceprice(double deviceprice) {
		this.deviceprice = deviceprice;
	}
	public int getDevicenumber() {
		return devicenumber;
	}
	public void setDevicenumber(int devicenumber) {
		this.devicenumber = devicenumber;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	
}
