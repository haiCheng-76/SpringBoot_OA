package com.example.demo.domain;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 995460259854060661L;
	private int departmentid;
	private String departmentname;
	private String departmenttelephone;
	private String departmentaddress;
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDepartmenttelephone() {
		return departmenttelephone;
	}
	public void setDepartmenttelephone(String departmenttelephone) {
		this.departmenttelephone = departmenttelephone;
	}
	public String getDepartmentaddress() {
		return departmentaddress;
	}
	public void setDepartmentaddress(String departmentaddress) {
		this.departmentaddress = departmentaddress;
	}
	
}
