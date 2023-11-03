package com.lec.ch05.quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner input = new Scanner(System.in);
		
		System.out.println("DEV ? ---- RUN ?");
		String answer = input.next();
		
		if(answer.equalsIgnoreCase("DEV")) {
			config = "dev";
		} else if(answer.equalsIgnoreCase("RUN")) {
			config = "run";
		} else {
			System.out.println("잘못된 환경정보입니다. 확인바랍니다.");
			System.exit(0);
		}
		input.close();
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.getEnvironment().setActiveProfiles(config);
		
		String parsingData1 = "classpath:META-INF/quiz/dev.xml";
		String parsingData2 = "classpath:META-INF/quiz/run.xml";
		
		ctx.load(parsingData1, parsingData2);
		
		ctx.refresh();
		
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		
		System.out.println("ip :" + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		System.out.println("ID : " + info.getUserId());
		System.out.println("Password : " + info.getUserPw());
		
		ctx.close();
	}
}
