package com.lec.ex1_string;

import java.util.Scanner;

//전화번호 뒷자리가 중복 x 경우
public class Ex07_searchTel {

	public static void main(String[] args) {
		
		while(true) {
			String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-7777"};
			
			Scanner sc = new Scanner(System.in);
			
			
			System.out.print("검색하고자 하는 회원의 전화번호 뒷자리를 입력하세요 >> ");		
			
			String searchTel = sc.next();
			
			if(searchTel.equalsIgnoreCase("x")) {
				
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			int idx;
			
			for(idx = 0; idx < tels.length; idx++) {
				
				int postIdx = tels[idx].lastIndexOf("-");
				String postTel = tels[idx].substring(postIdx + 1);
				
				if(postTel.equals(searchTel)) {
					
					System.out.println("검색하신 전화번호는 : " + tels[idx] );
					break;
				}
			}
			if(idx == tels.length) {
				
				System.out.println("입력하신 전화번호 뒷자리는 저장되지 않았습니다.");
				
			}
		}
	}
	
}
