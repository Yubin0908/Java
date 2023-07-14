package com.lex.ex3_exceptionEx;

import java.util.Date;

public class Ex02_FriendNullPointException {

	public static void main(String[] args) {
		
		Friend hong = new Friend("홍길동", "010-9999-9999", new Date(98, 11, 12));
		
		System.out.println(hong);
		
		Friend kim = new Friend("김길동", "010-8888-8888");
		
		System.out.println(kim);
		
	}
	
}