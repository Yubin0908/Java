package com.lec.ch04.ex1_auto;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutoWiredTestMain {
	public static void main(String[] args) {
		String parsingData = "classpath:META-INF/ex1/applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(parsingData); // Container Create
		
		Student student = ctx.getBean("student", Student.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		
		Student student2 = studentInfo.getStudent();
		
		System.out.println("student : " + student);
		System.out.println("studentInfo 내부 student : " + student2);
		
		if(student.equals(student2)) {
			System.out.println("student & student2 동일");
		} else {
			System.out.println("student & student2 동일 안함");
		}
		
		ctx.close();
	}
}
