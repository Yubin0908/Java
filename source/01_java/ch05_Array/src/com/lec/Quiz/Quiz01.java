package com.lec.Quiz;

public class Quiz01 {

	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92, 100, 65, 20, 805, 626 }; // 배열 초기화

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				
				if (arr[i] > arr[j])   { 

					int temp = arr[i]; // i값을 temp로 복제

					arr[i] = arr[j]; //i값 자리에 j값으로 덮어씀

					arr[j] = temp; //j값을 temp로 복제
				}
			}
		}

		for (int num : arr) {

			System.out.print(num + " "); //결과값 출력

		}
	}

}
