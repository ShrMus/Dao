package com.shrmus.jdbc01.service;

import java.util.List;

import com.shrmus.jdbc01.dao.StudentDao;
import com.shrmus.jdbc01.pojo.Student;

public class StudentService {
	
	/**
	 * 查找所有学生
	 * @return
	 */
	public List<Student> getStudentList(){
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList();
		return studentList;
	}
	
	/**
	 * 添加一个学生的信息
	 * @param student
	 * @return
	 */
	public int addStudent(Student student) {
		StudentDao studentDao = new StudentDao();
		int accpetRow = studentDao.addStudent(student);
		return accpetRow;
	}
}
