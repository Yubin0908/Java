package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Friend> friends = new ArrayList<>(); // 객체생성

		friends.add(new Friend("홍길동", "서울 서대문구", "010-9999-9999", new Date(98, 05, 23)));
		friends.add(new Friend("신길순", "경기도 고양시", "010-8888-8888", new Date(98, 11, 05)));
		friends.add(new Friend("신길동", "서울 송파구", "010-7777-7777", new Date(96, 01, 01)));
		friends.add(new Friend("장동건", "부산 해운대구", "010-6666-6666", new Date(95, 03, 11)));
		friends.add(new Friend("홍길순", "경기도 부천시", "010-5555-5555", new Date(99, 07, 31)));

		while (true) {
			boolean check = false;

			System.out.print("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하시오) : ");

			String users = sc.nextLine();

			if (users.equalsIgnoreCase("x")) {

				System.out.print("※프로그램 종료");
				break;
			}

			for (Friend friend : friends) {

				String adr = friend.getAddress();

				int i = adr.indexOf(" ");

				String temp = adr.substring(0, i);

				if (users.equals(temp)) {

					System.out.println(friend);

					check = true;
				}

			}
			if (!check) {

				System.out.println("해당 지역의 친구가 없습니다");

			}

		}
	}

}
