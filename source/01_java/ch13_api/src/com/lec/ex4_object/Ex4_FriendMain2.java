package com.lec.ex4_object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex4_FriendMain2 {

	public static void main(String[] args) {

		Friend[] friends = { new Friend("홍길동","010-9999-9999", "서울 서대문구", new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
									new Friend("신길동", "010-8888-9999", "안양 만안구", new Date(new GregorianCalendar(1996, 6, 22).getTimeInMillis())),
									new Friend("김길동", "010-8888-777", "인천 중구", new Date(new GregorianCalendar(1996, 6, 2).getTimeInMillis())),
									new Friend("박성광", "010-8888-6666", "서울 용산구", new Date(new GregorianCalendar(1996, 7, 22).getTimeInMillis())),
									new Friend("윤동주", "010-8888-5555", "함북 청진시", new Date(new GregorianCalendar(1996, 6, 2).getTimeInMillis()))};

		Scanner scanner = new Scanner(System.in);
		// 검색할 지역 입력(서울) => 배열 검색(0번째 인덱스부터 비교 후 같으면 출력)
		while (true) {

			boolean searchOk = false; // 못 찾았다를 초기화

			System.out.print("검색할 지역을 입력 (단, 종료를 원하시면 x를 입력하시오) : ");

			String searchWord = scanner.next(); // 경기도

			if (searchWord.equalsIgnoreCase("x"))
				break;

			for (Friend friend : friends) {
				

				String address = friend.getAddress();

				int ad = address.indexOf(" ");

				String temp = address.substring(0, ad);

				
				if (searchWord.equals(temp)) {

					System.out.println(friend);

					searchOk = true;

				}
			}
			if (!searchOk) { // 해당 생일의 친구를 못 찾음

				System.out.println("해당 지역의 친구는 없습니다");

			}
		}
	}
}
