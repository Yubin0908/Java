package com.lec.ex;

public class Ex03 {

	public static void main(String[] args) {
		//변수 초기화
		int i = 10;
		int j = i;
		j = 99;
		
		System.out.println(i + "\t" + j);
		
		int[] score = {10, 20, 30, 40, 50};
		int[] s = score;
		
		for(int idx=0; idx < score.length; idx++ ) {
			
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
			
		
		}
		System.out.println("\n");
		
		s[0] = 99;
		for(int idx=0; idx < score.length; idx++ ) {
			
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
			
		
		}
	}
	
}
