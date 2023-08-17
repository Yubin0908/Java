package com.lec.ex3_product;
//데이터 : serialNo.
//Product p = new Product();
public class Product {
	
	private int serialNo;
	public static int count = 100;
	
	public Product() { 
		serialNo = ++count;
		
	}
	public void infoPrint() {
		
		System.out.println("시리얼번호 : " + serialNo + " \t 현재 count 공유번수 : " + count);
		
	}
	public static void staticMethod() {
		
		System.out.println("static 메소드");
		
	}
	
	
	
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Product.count = count;
	}
	
	
	
}
