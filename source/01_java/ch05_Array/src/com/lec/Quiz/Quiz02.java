package com.lec.Quiz;

public class Quiz02 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50 }; // 배열 초기화
		int total = 0; // total 변수 초기화

		for (int i = 0; i < arr.length; i++) {

			total += arr[i]; // 합계 계산

		}

		System.out.println("합계: " + total); // 결과값 출력

	}

}
