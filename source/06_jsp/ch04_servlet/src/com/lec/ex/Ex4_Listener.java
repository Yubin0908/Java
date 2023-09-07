package com.lec.ex;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// @WebListener
public class Ex4_Listener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 load되는 시점에 실행
		System.out.println("☆☆☆☆☆ch04가 시작될때(웹 프로젝트가 메모리에 구동 시작)☆☆☆☆☆");

	};
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에서 소멸되는 시점에 실행
		System.out.println("☆☆☆☆☆ch04가 종료될때(웹 프로젝트가 메모리에서 해제)☆☆☆☆☆");
	};
};
