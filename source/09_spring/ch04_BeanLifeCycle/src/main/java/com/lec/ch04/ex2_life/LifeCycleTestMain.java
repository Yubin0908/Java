package com.lec.ch04.ex2_life;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeCycleTestMain {
	public static void main(String[] args) {
		String parsingData = "classpath:META-INF/ex2/applicationCTX.xml";
		
		System.out.println("1. Container 생성");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("2. Pasing");
		ctx.load(parsingData);
		System.out.println("3. Bean 객체 생성");
		ctx.refresh();
		System.out.println("4. 주입받은 Bean 사용");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		System.out.println("5. Container 소멸(Bean 함께 소멸)");
		ctx.close();
	}
}
