package com.lec.ch04.ex3_scope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingletonTestMain {
	public static void main(String[] args) {
		String parsingData = "classpath:META-INF/ex3/applicationCTX.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(parsingData);
		
		Friend friend1 = ctx.getBean("friend", Friend.class);
		Friend friend2 = ctx.getBean("friend", Friend.class);
		
		System.out.println("fridend1 : " + friend1);
		System.out.println("friend2 : " + friend2);
		
		friend1.setFriendNo(9);
		friend1.setName("박길숙");
		friend1.setTel("000-0000-0000");
		
		System.out.println("fridend1 : " + friend1);
		System.out.println("friend2 : " + friend2);
		System.out.println("---------------------------위는 Singleton, 아래를 Proto-----------------------------");
		Friend friendProto1 = ctx.getBean("friendProto", Friend.class);
		Friend friendProto2 = ctx.getBean("friendProto", Friend.class);
		
		friendProto1.setFriendNo(999);
		friendProto1.setName("구구구");
		friendProto1.setTel("000");
		
		System.out.println("friendProto1 : " + friendProto1);
		System.out.println("friendProto2 : " + friendProto2);
	}
}
