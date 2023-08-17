package com.lec.ex6_wrapper;

import com.lec.ex4_object.Card;

public class Ex01 {

	public static void main(String[] args) {
		
		int i = 10;
		Integer iObj = 10; //new Integer(10); 객체자동생성
		Double dObj = 2.2;
		Card c1 = new Card("하트", 3);

	
		System.out.println(c1.equals(i));
	
	
	}
}
