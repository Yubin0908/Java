package com.lec.ex1_string;

/**
 * 데이터 영역, heap 영역, 상수 pool
 *
 *
 *
 */
public class Ex01 {

	public static void main(String[] args) {

		int i = 10;
		String str1 = "Java"; // heap영역 객체 생성(문자열 상수)
		String str2 = "Java"; // 이미 생성되어있는 상수를 공유

		String str3 = new String("Java"); // new로 객체 새로 생성

		if (str1 == str2) {

			System.out.println("str1과 str2는 같은 주소를 참조");

		} else {

			System.out.println("str1과 str2는 다른 주소를 참조");

		}
		System.out.println(str1 == str3 ? "str1과 3은 같은주소" : "st1과 3 은 다른주소");

		str2 = "Oracle";
		if (str1 == str2) {

			System.out.println("수정후 : str1과 str2는 같은 주소를 참조");

		} else {

			System.out.println("수정후 : str1과 str2는 다른 주소를 참조");

		}
	}

}
