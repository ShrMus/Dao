package com.shrmus.jdbc01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shrmus.jdbc01.util.DBUtil;
import com.shrmus.jdbc01.pojo.Student;

public class StudentDao {
	
	/**
	 * 查找所有学生
	 * @return
	 */
	public List<Student> getStudentList(){
		List<Student> studentList = new ArrayList<>();
		// 获取数据库连接对象
		Connection connection = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 获取SQL执行对象
			statement = connection.createStatement();
			// sql语句
			String sql = "select stu_id,stu_name,stu_age,stu_gender from jdbc01_student";
			// 获取结果集
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Student student = new Student();
				// 根据列名获取值
				String idString = resultSet.getString("stu_id");
				String nameString = resultSet.getString("stu_name");
				String ageString = resultSet.getString("stu_age");
				String genderString = resultSet.getString("stu_gender");
				
				int id = Integer.parseInt(idString);
				int age = Integer.parseInt(ageString);
				int gender = Integer.parseInt(genderString);
				
				// 封装学生的信息
				student.setId(id);
				student.setName(nameString);
				student.setAge(age);
				student.setGender(gender);
				
				// 添加到集合中
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			DBUtil.close(resultSet, statement, connection);
		}
		return studentList;
	}
	
	/**
	 * 添加一条记录
	 * @param student
	 * @return
	 */
	public int addStudent(Student student) {
		// 受影响的行数
		int acceptRow = 0;
		// 获取数据库连接对象
		Connection connection = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 获取SQL执行对象
			statement = connection.createStatement();
			// sql语句
			String sql = "insert into jdbc01_student(stu_id,stu_name,stu_age,stu_gender) "
			+ "values("+student.getId()+",'"+student.getName()+"',"+student.getAge()+","+student.getGender()+")";
			System.out.println(sql);
			acceptRow = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			DBUtil.close(resultSet, statement, connection);
		}
		return acceptRow;
	}
}
