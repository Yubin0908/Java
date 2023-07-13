package com.lec.ex5_scanner;

import java.util.Scanner;

// 이름(톰크루즈 || 홍길동) -> 주소 -> 나이
public class Ex03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 >> ");
		String name = scanner.nextLine();
		
		System.out.print("주소 >> ");
		String address = scanner.nextLine();
		
		System.out.print("나이 >> ");
		int age = scanner.nextInt();
		
		
		System.out.println("이름 : " + name + " 주소 : " + address + " 나이 : " + age);
		
	}
}
