package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch14.vo.Dept;
@Mapper
public interface DeptDao {
	public List<Dept> deptList();
}
