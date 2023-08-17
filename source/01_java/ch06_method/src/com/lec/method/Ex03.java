package com.lec.method;
//같은 패키지 내에서 메소드 호출
public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("-9의 절대값은 : " + Arithmetic.abs(-9)); //static method 형태만 호출 가능.

		Arithmetic ar = new Arithmetic(); //Non-static method 호출을 위한 변수 선언
		
		int tot = ar.sum(11, 100);
	
		
		System.out.println("11부터 100까지의 누적합은 : " + tot);
		
		System.out.println(ar.evenOdd(tot));
		
		tot = ar.sum(10);
		
		System.out.println("10까지의 합은 : " + tot);
		
	}

}
