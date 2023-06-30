package com.lec.ex;

public class Ex02_method {
	public static void main(String[] args) {
		
		int tot = sum(1, 10); //sum((int from)1, (int to)10);
		
		System.out.println("1~10까지 정수의 합은 : " + tot ); 
		System.out.println(evenOdd(tot)); //evenOdd -> tot(value값) -> evenOdd(int value) -> return
		
		tot = sum(11, 100);
		System.out.println("11~100까지 정수의 합은 : " + tot);
		System.out.println(evenOdd(tot));
		System.out.println("1~100까지 정수의 합은  :	" + sum(1,100));		

	}
	//parameter(=매개 변수:from, to)를 받아 from부터 to까지 누적한 합을 return하는 메소드
	private static int sum(int from, int to) {
		
		int sum = 0; // 누적 변수
		
		for(int i=from; i <=to; i++) {
			
			sum += i;
			
		}
		return sum; // 반환
	}
	
	//parameter를 받아 짝홀수 여부를 문자열로 return하는 메소드
	private static String evenOdd(int value) {
		
		String result = value%2 == 0 ? "짝수입니다" : "홀수입니다"; //삼항 연산자 사용
		
		return result; // 반환
		
	}
	
}
