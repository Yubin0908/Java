package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		System.out.println("전화번호를 입력하세요. >> ");
		

		String dial = scanner.next();
		
		System.out.println("입력하신 번호는 : " + dial);
		
		System.out.println(" 짝수번째 번호는 : ");
		for(int idx = 0; idx < dial.length(); idx++) {
			
			
			
		}
		System.out.println("앞자리 번호는 : " + dial.substring(0, 3));
		
		System.out.println("뒷자리 번호는 : " + dial.substring(8, 12));

	}
}

