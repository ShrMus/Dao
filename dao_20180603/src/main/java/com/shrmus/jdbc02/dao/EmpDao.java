package com.shrmus.jdbc02.dao;

import java.util.List;

import com.shrmus.jdbc02.pojo.Emp;
import com.shrmus.jdbc02.util.MyQuery;

public class EmpDao {
	/**
	 * 添加员工的信息
	 */
	public void insert(Emp emp) {
		MyQuery myQuery = new MyQuery();
		myQuery.insert(emp);
	}
	
	/**
	 * 查询所有员工
	 */
	public List<Emp> getEmpList() {
		MyQuery myQuery = new MyQuery();
		List<Emp> select = myQuery.select(Emp.class);
		return select;
	}
	
	/**
	 * 根据主键查询员工的信息
	 */
	public Emp selectByPrimaryKey(Emp emp) {
		MyQuery myQuery = new MyQuery();
		emp = myQuery.selectByPrimaryKey(emp);
		return emp;
	}
	
	/**
	 * 根据主键修改员工的信息
	 */
	public void updateByPrimaryKey(Emp emp) {
		MyQuery myQuery = new MyQuery();
		myQuery.updateByPrimaryKey(emp);
	}
	
	/**
	 * 根据主键删除员工的信息
	 */
	public void deleteByPrimaryKey(Emp emp) {
		MyQuery myQuery = new MyQuery();
		myQuery.deleteByPrimaryKey(emp);
	}
}
