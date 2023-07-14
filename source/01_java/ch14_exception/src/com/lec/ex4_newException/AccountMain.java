package com.lec.ex4_newException;

public class AccountMain {

	public static void main(String[] args) {
		
		Account hong = new Account("011-1234", "홍길동", 500000);
		
		System.out.println(hong);
//		hong.infoPrint();
		
		Account hong1 = new Account("012-1234", "홍길자", 0);
		System.out.println(hong1);
		
		try {
			hong.withdraw(5000);
		} catch (Exception e) {

			System.out.println("예외 메시지 : " + e.getMessage());
		}
		
		try {
			hong1.withdraw(10);
		} catch (Exception e) {
			
			System.out.println("예외 메시지 : " + e.getMessage());
		}
		hong1.deposit(100000);
		
	}
	
	
}
