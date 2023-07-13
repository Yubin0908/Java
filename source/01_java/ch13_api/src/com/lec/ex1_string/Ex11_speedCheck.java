package com.lec.ex1_string;

public class Ex11_speedCheck {

	public static void main(String[] args) {
		
//		System.out.println(System.currentTimeMillis()); //1970. 1. 1. 0시부터 현재까지의 ms.
		
		long start = System.currentTimeMillis();
		
		String str = "a";
		
		for(int i = 0; i < 100000; i++) {
			
			str += "a";
			
		}
		long end = System.currentTimeMillis();
		
		start = System.currentTimeMillis();
		System.out.println("String 변경 시간 : " + (end-start));
		
		StringBuffer strBuf = new StringBuffer("a");
		
		for(int i = 0; i < 100000; i++) {
			
			strBuf.append("a");
			
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer 변경 시간 : " + (end-start));
	}
	
}
