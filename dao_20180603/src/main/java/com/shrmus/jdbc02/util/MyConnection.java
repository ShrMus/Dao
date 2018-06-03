package com.shrmus.jdbc02.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 自定义连接
 * <p>Title:MyConnection</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年6月3日上午9:59:31
 * @version
 */
public final class MyConnection{
	
	private Connection connection = null;
	
	public MyConnection() {
		
	}
	
	public MyConnection(MyDataSource myDataSource) {
		try {
			Class.forName(myDataSource.getDriverClassName());
			connection = DriverManager.getConnection(myDataSource.getUrl(), myDataSource.getUsername(), myDataSource.getPassword());
		} catch (ClassNotFoundException e) {
			System.err.println("构造MyConnection实例失败！");
		} catch (SQLException e) {
			System.err.println("获取MyConnection失败！");
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * 关闭数据库连接对象
	 * @param connection
	 */
	public static void close(Connection connection) {
		if(null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("关闭数据库连接对象失败！");
			}
		}
	}
	
	/**
	 * 关闭SQL执行对象
	 * @param statement
	 */
	public static void close(Statement statement) {
		if(null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("关闭SQL执行对象失败！");
			}
		}
	}
	
	/**
	 * 关闭结果集对象
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		if(null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.err.println("关闭结果集对象失败！");
			}
		}
	}
	
	/**
	 * 关闭数据库连接对象，SQL执行对象，结果集对象
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void close(ResultSet resultSet, Statement statement, Connection connection){
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.err.println("关闭结果集对象失败！");
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("关闭SQL执行对象失败！");
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("关闭数据库连接对象失败！");
			}
		}
	}
}
