package com.lec.ex;
//배열 복제
public class Ex04_arraycopy {

	public static void main(String[] args) {
		//메모리 할당
		int[] score = { 100, 20, 30, 40, 50};
		//새로운 메모리 할당
		int[] s = new int[score.length];
 		//배열 복사 Method
		System.arraycopy(score, 0, s, 0, score.length);
		
//		for(int i=0; i  < s.length; i++) {
//			
//			s[i] = score[i];				
//			
//		}
		for(int i=0; i < s.length; i++) {
			
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", i, score[i], i, s[i]);
			
		}
		System.out.println("\n");
		s[0]= 99;
		
		for(int i=0; i < s.length; i++) {
			
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", i, score[i], i, s[i]);
			
		}
	}
}
