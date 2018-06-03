package com.shrmus.jdbc01.test;

import java.util.List;

import org.junit.Test;

import com.shrmus.jdbc01.service.StudentService;
import com.shrmus.jdbc01.pojo.Student;

public class StudentTest {
	
	@Test
	public void getStudentList() throws Exception{
		StudentService studentService = new StudentService();
		List<Student> studentList = studentService.getStudentList();
		for(Student student : studentList) {
			System.out.println(student);
		}
	}
	
	@Test
	public void addStudent() throws Exception{
		StudentService studentService = new StudentService();
		Student student = new Student();
		student.setId(1);
		student.setName("张三");
		student.setAge(20);
		student.setGender(1);
		studentService.addStudent(student);
	}
}
