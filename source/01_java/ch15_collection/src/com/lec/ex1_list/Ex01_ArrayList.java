package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01_ArrayList {
	
	public static void main(String[] args) {
		
		String[] array = new String[3];		
		array[0] = "str0"; array[1] = "str1"; array[2] = "str2";
		
		System.out.println(Arrays.toString(array));
		
		for(String arr : array) {
			
			System.out.println(arr);
			
		}
		for(int i = 0; i < array.length; i++) {
			
			System.out.println(i + "번째 인덱스 값 : " + array[i]);
			
		}
		System.out.println("=================  ArrayList  ==============================");
		
	
		ArrayList<String> arrayList = new ArrayList<>(); //객체 생성
		
		arrayList.add("str1"); //0번 인덱스
		arrayList.add("str2"); //1번 인덱스
		arrayList.add("str3"); //2번 인덱스
		arrayList.add(1, "str1111"); //1번 인덱스(지정)
		
		arrayList.set(2, "str2222");//2번 인덱스 수정

		System.out.println("arrayList의 사이즈 : " + arrayList.size()); //arrayList 크기
		
		arrayList.add("str4");// 3번 인덱스
		
		System.out.println("arrayList의 사이즈 : " + arrayList.size()); //arrayList 크기
		System.out.println(arrayList);
		
		for(String temp : arrayList) { //extend for문
			
			System.out.println(temp);
			
		}
		
		for(int i = 0; i < arrayList.size(); i++) { //normal for문
			
			System.out.println(i + "번째 인덱스 값은 : " + arrayList.get(i));
			
		}
		arrayList.remove(2); //2번째 인덱스의 값이 제거됨.(3번째 인덱스가 2로 내려옴.)
		
		arrayList.remove(arrayList.size() - 1);// 맨 마지막 인덱스 값 제거
		
		System.out.println("====  2번째 인덱스값 제거 & 맨 마지막 인덱스값 제거 후  =====");
		for(int i = 0; i < arrayList.size(); i++) { //normal for문
			
			System.out.println(i + "번째 인덱스 값은 : " + arrayList.get(i));
			
		}
		
		arrayList.clear(); // arrayList의 모든 데이터를 삭제
		
		System.out.println(arrayList.size() == 0 ? "데이터 제거 완료" : "데이터 있음");
		System.out.println(arrayList.isEmpty() ? "데이터 제거 완료" : "데이터 있음");
		//	 	사용 불가
		//		arrayList = null;
		//		System.out.println(arrayList.size());
	}
	

}
