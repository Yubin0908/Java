package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 의존관계 main -> MyCalcultor, MyCalculator -> Calculator
public class CalTestMain {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		MyCalculator myCalculator = ctx.getBean("myCal", MyCalculator.class);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		ctx.close();
	}
}
