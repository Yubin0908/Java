package com.lec.ex4_newException;

import java.util.Date;
import java.util.GregorianCalendar;

//책객체 -> 대출 -> 대출일 3주전(06-23) setting -> 반납 
public class BoolLibOverduTestMain {

	public static void main(String[] args) {
		
		Book book = new Book("950-ㄱ10", "이것이 자바다", "신윤권");
		
		System.out.println("대출 전 : " + book);
		book.checkOut("홍길동"); //대출
		//book.setCheckOutDate(new Date(2023-1990, 5, 23));
		book.setCheckOutDate(new Date(new GregorianCalendar(2023, 5, 23).getTimeInMillis()));
		
		System.out.println("대출 후 : " + book);
		
		try {
			book.checkIn();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		System.out.println("반납처리 확인 : " + book);
		
		
		
	}
	
}
