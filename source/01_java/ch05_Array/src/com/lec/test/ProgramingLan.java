package com.lec.test;

public class ProgramingLan {

	public static void main(String[] args) {
		int[] numArr = { 76, 45, 34, 89, 100, 50, 90, 93 };

		// 합계 계산
		int total = 0;
		for (int i = 0; i < numArr.length; i++) {
			total += numArr[i];
		}

		// 평균 계산
		double average = (double) total / numArr.length;

		// 최대값 계산
		int maxNum = numArr[0];
		int minNum = numArr[0];

		for (int i = 0; i < numArr.length; i++) {

			if (numArr[i] > maxNum) {
				maxNum = numArr[i];
			}
			if (numArr[i] < minNum) {
				minNum = numArr[i];
			}
		}

		// 최소값 계산

		for (int i = 1; i < numArr.length; i++) {
			if (numArr[i] < minNum) {
				minNum = numArr[i];
			}
		}

		// 결과값 출력
		System.out.print("합계: " + total + "   \t");
		System.out.print("평균: " + average + "\t\n");
		System.out.print("최대값: " + maxNum + "\t");
		System.out.print("최소값: " + minNum);

	}

}