package com.lec.ex4_newException;
/*  은행계좌(Account) 클래스 설계
데이터(속성) : 계좌번호, 예금주, 잔액
기능(메소드) : 예금하다. 인출하다 */
public class Account {

	private String accountNo;
	private String ownerName;
	private long balance;
	
	public Account(String accoutNo, String ownerName) {
		
		this.accountNo = accoutNo;
		this.ownerName = ownerName;
		
		System.out.println(ownerName + " 님 계좌개설 감사합니다. 잔액 0원 ");
		
	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		
		System.out.println(ownerName + " 님 계좌개설 진심으로 감사합니다. 잔액 : " + balance + " 원입니다.");
	}
	
	public void deposit(int money) {
		
		balance += money;
		
		System.out.println(accountNo + " : " + money + "원 예금하여 잔액 : " + balance + "원입니다.");
		
	}
	public void withdraw(int money) throws Exception{
		
		if(balance >= money) {
			
			balance -= money;
			
			System.out.println(accountNo + " : " + money + "원 인출 하여 잔액이 : " + balance + "원 남았습니다." );
		}else {
			
			throw new Exception(ownerName + "님의 잔액이 부족하여 인출이 불가합니다.");
		}
	}
	@Override
	public String toString() {
		
		return " \" " + accountNo + " \" " + ownerName + "님의 잔액은 : " + balance + "원 입니다.";
		
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public long getBalance() {
		return balance;
	}


	
}
	
	
	
	

