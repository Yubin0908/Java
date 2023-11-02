package com.lec.ch02.ex2_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		// String 설정파일을 parsing해서 Container 생성 - student1, student2, studentPrint Bean 셍성
		StudentPrint sPrint = ctx.getBean("studentPrint", StudentPrint.class);
		sPrint.print();
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		
		if(sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint의 student는 student1과 같은 객체");
		} else {
			System.out.println("sPrint의 student는 student1과  다른 객체");
		}
		
		sPrint.setStudent(student2);
		sPrint.print();
		
		if(sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint의 student는 student1과 같은 객체");
		} else {
			System.out.println("sPrint의 student는 student1과  다른 객체");
		}
		ctx.close();
	}
}
