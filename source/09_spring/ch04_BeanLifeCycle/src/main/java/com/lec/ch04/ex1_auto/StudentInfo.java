package com.lec.ch04.ex1_auto;

import org.springframework.beans.factory.annotation.Autowired;
// 의존객체의 자동 주입
public class StudentInfo {
	@Autowired // Field 주입
	private Student student;
	
//	@Autowired // Constructor 주입
//	public StudentInfo(Student student) {
//		super();
//		this.student = student;
//	}
//	@Autowired // Setter 주입
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	public Student getStudent() {
		return student;
	}
}
