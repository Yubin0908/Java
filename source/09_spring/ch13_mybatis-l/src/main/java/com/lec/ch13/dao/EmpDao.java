package com.lec.ch13.dao;

import java.util.List;

import com.lec.ch13.vo.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);
}
