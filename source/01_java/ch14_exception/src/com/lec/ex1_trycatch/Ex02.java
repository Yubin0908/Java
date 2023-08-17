package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int i, j = 1; // 사용자에게 입력받을 수 저장

		do {
			try {

				System.out.print("첫번째 정수는(사칙연산 결과를 위한) >> ");
				i = scanner.nextInt();
				break;

			} catch (InputMismatchException e) {

				System.out.println("수에 문자를 넣지 마세요.");
				scanner.nextLine();
			}

		} while (true);
		
		System.out.print("두번째 정수는(사칙연산 결과를 위한) >> ");
			
		try {
			j = scanner.nextInt();
			System.out.println(" i / j = " + (i / j)); // 예외가 발생할 수도 있고, 안할 수도 있는 부분

		} catch (ArithmeticException e) { // ArithmeticException 예외 객체 발생 시 수행하는 부분
			// e.printStackTrace(); // 좀 더 자세한 예외 메세지
			System.out.println(e.getMessage()); // 예외 객체의 예외 메세지 출력
			
		} catch (RuntimeException e) { // InputMismatchException 예외 객체 발생 시 수행하는 부분
			System.out.println(e.getMessage()); // 예외 객체의 예외 메세지 출력 // 예외 메세지 없는 경우 null값 발생.
			System.out.println(" 두번째 정수를 잘못 입력하시면 무조건 1로 처리합니다");
			
		}
		System.out.println(" i + j = " + (i + j));
		System.out.println(" i - j = " + (i - j));
		System.out.println(" i * j = " + (i * j));
		System.out.println("DONE");

		scanner.close();
	}

}
