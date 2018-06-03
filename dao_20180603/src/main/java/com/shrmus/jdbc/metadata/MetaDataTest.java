package com.shrmus.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class MetaDataTest {
	/**
	 * 获取数据库元数据
	 */
	@Test
	public void getDatabaseMetaData() throws Exception{
		Connection connection = JDBCUtil.getConnection();
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		// 获取数据库名称
		String databaseProductName = databaseMetaData.getDatabaseProductName();
		System.out.println(databaseProductName);
		// 获取驱动版本
		String driverName = databaseMetaData.getDriverVersion();
		System.out.println(driverName);
		// 获取数据库连接URL
		String url = databaseMetaData.getURL();
		System.out.println(url);
		// 获取用户名
		String userName = databaseMetaData.getUserName();
		System.out.println(userName);
		JDBCUtil.close(null, null, connection);
		
//		ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});
//		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//		// 获取结果集返回的列数
//		int columnCount = resultSetMetaData.getColumnCount();
//		System.out.println(columnCount);
//		for(int i = 0; i < columnCount; i++) {
//			String columnName = resultSetMetaData.getColumnName(i + 1);
//			System.out.print(columnName + "\t");
//		}
//		while(resultSet.next()) {
//			System.out.println();
//			for(int i = 0; i < columnCount; i++) {
//				String columnName = resultSetMetaData.getColumnName(i + 1);
//				Object object = resultSet.getObject(columnName);
//				System.out.print(object == null?"null\t":object.toString() + "\t");
//			}
//		}
	}
	
	/**
	 * 获取SQL执行对象元数据
	 */
	@Test
	public void getParameterMetaData() throws Exception {
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into emp(id,name,address,hiredate) values(?,?,?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ParameterMetaData parameterMetaData = prepareStatement.getParameterMetaData();
		// 取到参数个数
		int parameterCount = parameterMetaData.getParameterCount();
		System.out.println(parameterCount);
		
		JDBCUtil.close(null, prepareStatement, connection);
	}
	
	/**
	 * 获取结果集元数据
	 */
	@Test
	public void getResultSetMetaData() throws Exception{
		// 获取数据库连接对象
		Connection connection = JDBCUtil.getConnection();
		// sql语句
		String sql = "select id,name,address,hiredate from emp";
		// 获取SQL执行对象
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		// 获取结果集
		ResultSet resultSet = prepareStatement.executeQuery();
		// 获取结果集元数据
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		// 获取查询出来的总列数
		int columnCount = resultSetMetaData.getColumnCount();
		System.out.println("columnCount : " + columnCount);
		// 获取指定列的类型常量，在java.sql.Types类中可以查找到
		int columnType = resultSetMetaData.getColumnType(2);
		System.out.println("columnType : " + columnType);
		// 获取指定列的类型字符串，如INT,VARCHAR
		String columnTypeName = resultSetMetaData.getColumnTypeName(2);
		System.out.println("columnTypeName : " + columnTypeName);
		// 获取指定列的列名，如hiredate
		String columnName = resultSetMetaData.getColumnName(4);
		System.out.println("columnName : " + columnName);
		JDBCUtil.close(resultSet, prepareStatement, connection);
	}
	
}
