package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorTestMain {
	public static void main(String[] args) {
		
//		Calculator cal = new Calculator();
//		cal.setNum1(10);
//		cal.setNum2(5);
		// applicationCTX.xml을 parsing하여 bean 생성(IOC 컨테어너)
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		// IOC 컨테이너에 있는 빈을 주입(DI)
		
		Calculator cal = ctx.getBean("cal", Calculator.class);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		ctx.close();
	}
}
