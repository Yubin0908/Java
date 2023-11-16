package com.lec.ch14.service;

import java.util.List;

import com.lec.ch14.vo.Dept;
import com.lec.ch14.vo.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
