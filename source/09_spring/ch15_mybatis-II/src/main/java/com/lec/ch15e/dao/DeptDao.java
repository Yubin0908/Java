package com.lec.ch15e.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch15e.vo.Dept;

@Mapper
public interface DeptDao {
	public List<Dept> deptList();
}
