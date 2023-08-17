package com.lec.quiz;

import java.util.Scanner;

public class quiz_Gugudan {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);

		int user;
		
		do {
			
			System.out.println("원하는 값(2~9사이)을 입력하세요 : ");
			
			user = num.nextInt();
			
		}while(user < 2 || 9 < user);
		
		gugudan(user);

	}

	public static void gugudan(int num) {

		for (int i = 1; i <= 9; i++) {

			int result = num * i;

			System.out.println(num + " x " + i + " = " + result);

		}
	}
}