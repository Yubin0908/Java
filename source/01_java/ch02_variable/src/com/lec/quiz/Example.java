package com.lec.quiz;

public class Example {
	
	public static void main(String[] args) {
		
		int korean;
		int english;
		int math;
		
		
		korean = 100;
		english = 99;
		math = 100;
		
		String score_ko;
		String score_en;
		String score_math;
		String total_score;
		String avg_score;
		
		score_ko = "국어점수 : ";
		score_en = "영어점수 : ";
		score_math = "수학점수 : ";
		total_score = "총점수 : ";
		avg_score = "평균점수 : ";
		
		int result = korean + english + math ;
		
		System.out.println( score_ko +  korean );
		System.out.println( score_en + english );
		System.out.println( score_math + math);
		
		System.out.println( total_score + result);
		System.out.println( avg_score + (float)result/3);
		
	}
}
