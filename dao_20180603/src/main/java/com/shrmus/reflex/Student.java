package com.shrmus.reflex;

import java.sql.SQLException;

public class Student {
	private int id;
	private String name;
	protected int age;
	public int gender;
	
	public Student() {
		
	}
	
	public Student(int id) {
		this.id = id;
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	private Student(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	protected Student(int id,String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Student(int id,String name,int age,int gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	private void test01() throws RuntimeException{
		
	}
	
	protected void test02() throws SQLException{
		
	}
	
	public static String test03() {
		return "test03()";
	}
	
	public static final Student test04(String string1,Student student) {
		System.out.println(string1 + " " + student.getName());
		return student;
	}
}
