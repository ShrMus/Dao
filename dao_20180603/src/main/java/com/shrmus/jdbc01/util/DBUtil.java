package com.shrmus.jdbc01.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MySQL数据库连接
 * <p>Title:MySQLConnection</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年6月2日下午2:12:16
 * @version
 */
public class DBUtil {
	/* 	数据库驱动，其实就是对应的jar中的驱动类的全路径
	 	MySQL:		com.mysql.jdbc.Driver
       	SQL Server:	com.microsoft.sqlserver.jdbc.SQLServerDriver
       	Oracle 11g:	oracle.jdbc.driver.OracleDriver
	 */
	private static final String DRIVE_STRING = "com.mysql.jdbc.Driver";
	/* 	数据库连接URL，数据库名为dao_20180603
	 	MySQL:  	jdbc:mysql://localhost:3306/dao_20180603
     	SQL Server: jdbc:sqlserver://localhost:1433;databaseName=dao_20180603
     	Oracle 11g: jdbc:oracle:thin:@localhost:1521:orcl
	 */
	private static final String URL_STRING = "jdbc:mysql://localhost:3306/dao_20180603?characterEncoding=utf8";
	// 数据库用户名
	private static final String USER_STRING = "root";
	// 数据库密码
	private static final String PASSWORD_STRING = "shrmus";
	// 数据库连接对象
	public static Connection connection;
	// SQL执行对象
	public static Statement statement;
	// 结果集对象
	public static ResultSet resultSet;
	
	// 加载驱动
	static {
		try {
			Class.forName(DRIVE_STRING);
		} catch (ClassNotFoundException e) {
			System.err.println("加载数据库驱动失败！");
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL_STRING, USER_STRING, PASSWORD_STRING);
		} catch (SQLException e) {
			System.err.println("获取数据库连接对象失败！");
		}
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
