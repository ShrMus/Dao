package com.shrmus.jdbc02.pojo;

import java.util.Date;

public class Emp {
	private int id;
	private String name;
	private String address;
	private Date hireDate;
	
	public Emp() {
		
	}
	
	public Emp(int id, String name, String address, Date hireDate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", address=" + address + ", hireDate=" + hireDate + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
}
