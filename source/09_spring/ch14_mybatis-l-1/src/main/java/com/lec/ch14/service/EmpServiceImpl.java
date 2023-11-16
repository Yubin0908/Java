package com.lec.ch14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch14.dao.DeptDao;
import com.lec.ch14.dao.EmpDao;
import com.lec.ch14.vo.Dept;
import com.lec.ch14.vo.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}

	@Override
	public List<Emp> empList(Emp searchEmp) {
		// emp.do => searchEmp.ename & searchEmp.job == null
		// emp.do?ename=e&job=m&deptno=0 => searchEmp.ename : "e"
		if(searchEmp.getEname() != null) {
			searchEmp.setEname(searchEmp.getEname().toUpperCase());
		}
		if(searchEmp.getJob() != null) {
			searchEmp.setJob(searchEmp.getJob().toUpperCase());
		}
		
		return empDao.empList(searchEmp);
	}

}
