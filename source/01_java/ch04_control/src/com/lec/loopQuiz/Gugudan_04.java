package com.lec.loopQuiz;

//1~9까지의 구구단 출력

public class Gugudan_04 {

	public static void main(String[] args) {

		for (int e = 1; e <= 9; e++) {

			for (int n = 2; n <= 9; n++) {

				System.out.print(n + " * " + e + " = " + e * n + "\t");

			}
			System.out.println();
		}

	}

}
