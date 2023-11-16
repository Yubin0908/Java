package com.lec.ch13.service;

import java.util.List;

import com.lec.ch13.vo.Dept;
import com.lec.ch13.vo.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
