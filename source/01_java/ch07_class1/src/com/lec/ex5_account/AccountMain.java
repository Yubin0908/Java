package com.lec.ex5_account;

public class AccountMain {

	public static void main(String[] args) {
		
		Account hong = new Account("011-1234", "홍길동", 500000);
		
		System.out.println(hong.infoString());
//		hong.infoPrint();
		
		Account hong1 = new Account("012-1234", "홍길자", 0);
		hong1.infoPrint();
		
		hong.withdraw(5000);
		
		hong1.withdraw(10);
		hong1.deposit(100000);
		
	}
	
	
}
