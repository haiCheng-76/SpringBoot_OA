package com.example.demo.domain;

import java.io.Serializable;

public class CarInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2060615972225487540L;
	private int carid;
	private String carname;
	private String carnumber;
	private double carprice;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public double getCarprice() {
		return carprice;
	}
	public void setCarprice(double carprice) {
		this.carprice = carprice;
	}
	
}
