package com.lec.ch05.ex3_profile;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ServerInfoTestMain {
	public static void main(String[] args) {
		String config = null; // statusble Resetting
		Scanner sc = new Scanner(System.in);
		
		System.out.print("DEV(개발중) ? ---- RUN(인수 테스트 후) ?");
		String answer = sc.next(); // DEV and RUN
		if(answer.equalsIgnoreCase("DEV")) {
			config = "dev";
		} else if(answer.equalsIgnoreCase("RUN")) {
			config = "run";
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다. 확인 요망.");
			System.exit(0);
		}
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String parsingData1 = "classpath:META-INF/ex3/applicationCTX_dev.xml";
		String parsingData2 = "classpath:META-INF/ex3/applicationCTX_run.xml";
		ctx.load(parsingData1, parsingData2);
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
	}
}
