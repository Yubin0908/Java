package com.lec.ex;

import com.lec.method.Arithmetic;

//다른패키지의 method 호출 (import 필요)
public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("-9의 절대값 : " + Arithmetic.abs(-9) + " 입니다. ");
		
		Arithmetic ar1 = new Arithmetic();
		
		int tot = ar1.sum(11, 100);
	
		
		System.out.println("11부터 100까지의 누적합은 : " + tot + " 입니다. ");
		
		System.out.println(ar1.evenOdd(tot));
		
		tot = ar1.sum(10);
		
		System.out.println("10까지의 합은 : " + tot + " 입니다. ");
		
	}
}
