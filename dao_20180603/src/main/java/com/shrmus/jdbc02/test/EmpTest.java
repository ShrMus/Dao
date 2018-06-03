package com.shrmus.jdbc02.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.shrmus.jdbc.metadata.JDBCUtil;
import com.shrmus.jdbc02.dao.EmpDao;
import com.shrmus.jdbc02.pojo.Emp;

public class EmpTest {
	/**
	 * 测试添加
	 */
	@Test
	public void inser() throws Exception{
		Emp emp = new Emp(2,"李四","株洲",new Date());
		EmpDao empDao = new EmpDao();
		empDao.insert(emp);
	}
	
	/**
	 * 测试查询所有员工
	 */
	@Test
	public void getEmpList() throws Exception {
		EmpDao empDao = new EmpDao();
		List<Emp> empList = empDao.getEmpList();
		for(Emp emp : empList) {
			System.out.println(emp);
		}
	}

	/**
	 * 测试根据主键查询
	 */
	@Test
	public void selectByPrimaryKey() throws Exception {
		EmpDao empDao = new EmpDao();
		Emp emp = new Emp();
		emp.setId(1);
		emp = empDao.selectByPrimaryKey(emp);
		System.out.println(emp);
	}
	
	/**
	 * 测试修改
	 */
	@Test
	public void updateByPrimaryKey() throws Exception {
		Emp emp = new Emp(1,"王五","广州",new Date());
		EmpDao empDao = new EmpDao();
		empDao.updateByPrimaryKey(emp);
	}

	/**
	 * 测试删除
	 */
	@Test
	public void deleteByPrimaryKey() throws Exception {
		Emp emp = new Emp(1,"李四","广州",new Date());
		EmpDao empDao = new EmpDao();
		empDao.deleteByPrimaryKey(emp);
	}

	@Test
	public void test() throws Exception {
		Connection connection = JDBCUtil.getConnection();
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		Class clazz = Emp.class;
		// 获取简单类名，数据库表名和类名一致
		String simpleName = clazz.getSimpleName();
		System.out.println(simpleName);
		ResultSet resultSet = databaseMetaData.getColumns("", "", simpleName,"");

		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int i = 0; i < columnCount; i++) {
			String columnName = resultSetMetaData.getColumnName(i + 1);
			System.out.print(columnName + "\t\t\t");
		}
		System.out.println();
		while(resultSet.next()) {
			for(int i = 0; i < columnCount; i++) {
				String columnName = resultSetMetaData.getColumnName(i + 1);
				Object object = resultSet.getObject(columnName);
				System.out.print(object == null?"null\t\t\t":object.toString() + "\t\t\t");
			}
			System.out.println();
			//			String string = resultSet.getString("COLUMN_NAME");
			//			System.out.println(string);
		}
	}
}
