package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

public class Ex03_FriendArrayListMain {
	
	public static void main(String[] args) {
		
		ArrayList<Friend> friends = new ArrayList<>(); //객체 생성
		
		friends.add(new Friend("홍길동", "010-9999-9999", new Date(98, 1, 1)));
		friends.add(new Friend("김길동", "010-8888-8888", new Date(98, 6, 1)));
		friends.add(new Friend("신길동", "010-7777-7777", new Date(98, 7, 11)));
		friends.add(new Friend("황길동", "010-6666-6666", new Date(98, 7, 14)));
		friends.add(new Friend("강길동", "010-5555-5555", new Date(98, 10, 5)));
		
		for(Friend friend : friends) { //extend for문
			
			System.out.println(friend);
		}
		for(int i = 0; i < friends.size(); i++) { //normal for문
			
			System.out.println(i + " : " + friends.get(i));
			
		}
		// 0번 인덱스부터 끝까지 이름을 출력하세요.
		for(Friend friend : friends) {
			
			String nameStr = friend.getName();
			
			System.out.print(nameStr + "\t");
		}
		System.out.println();
		
		for(int idx = 0; idx < friends.size(); idx++) {
			
			System.out.print(friends.get(idx).getName() + "\t");
			
		}
		
		
		
	}

}
