package com.lec.ch05.ex1_env;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {
	public static void main(String[] args) {
		// Container Create
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ConfigurableEnvironment env = ctx.getEnvironment(); // Enviroment 객체를 불러옴
		// env 의 속성과 속석값으로 되어있는 propertySourc를 가져옴
		MutablePropertySources propertySources = env.getPropertySources();
		// propertySource 뒤에 admin.proeprties의 내용을 추가
		String propertiesData = "classpath:META-INF/ex1/admin.properties";
		try {
			propertySources.addLast(new ResourcePropertySource(propertiesData));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id : " + env.getProperty("admin.id"));
		System.out.println("admin.pw : " + env.getProperty("admin.pw"));
		// 외부파일으 저보가 있는 env의 admin.id와 admin.pw를 Bean으로 생성
		ctx.load("classpath:META-INF/ex1/applicationCTX.xml");
		ctx.refresh();
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("admin객체의 admin.id : " + admin.getAdminId());
		System.out.println("admin객체의 admin.pw : " + admin.getAdminPw());
		System.out.println("env : " + admin.getEnv());
		
		ctx.close();
	}
}
