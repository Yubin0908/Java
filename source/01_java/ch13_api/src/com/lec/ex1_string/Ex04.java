package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("주민등록번호를 입력하세요 >> ");
		
		String num = scanner.next();
		
		
		System.out.println("입력하신 주민번호는 : " + num);
		

		String gender = num.substring(6, 7);
		
		System.out.println(gender);

		if(gender.equals("1")){
			
			System.out.println("남자입니다.");
			
		}else if(gender.equals("2")) {
			
			System.out.println("여자입니다.");
		
		}else if(gender.equals("3")) {
			
			System.out.println("남자입니다.");
		
		}else if(gender.equals("4"))
			
			System.out.println("여자입니다.");
		
		}

	}
