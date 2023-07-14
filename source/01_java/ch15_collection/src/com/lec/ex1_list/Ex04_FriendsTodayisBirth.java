package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex04_FriendsTodayisBirth {

	public static void main(String[] args) {

		ArrayList<Friend> friends = new ArrayList<>(); // 객체 생성

		friends.add(new Friend("홍길동", "010-9999-9999", new Date(98, 1, 1)));
		friends.add(new Friend("김길동", "010-8888-8888", new Date(98, 6, 1)));
		friends.add(new Friend("신길동", "010-7777-7777", new Date(98, 6, 14)));
		friends.add(new Friend("황길동", "010-6666-6666", new Date(98, 6, 14)));
		friends.add(new Friend("강길동", "010-5555-5555", new Date(98, 10, 5)));
		
		//오늘이 생일인 친구만 출력
		System.out.print("오늘이 생일인 친구는 : ");
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		
		String nowStr = sdf.format(now); 
		
		boolean none = true;
		
		for(Friend friend : friends) {
			
			Date birth = friend.getBirth();
			if(birth != null && sdf.format(birth).equals(nowStr)) {
				
					none = false;				
					System.out.print("\n" + friend);
				}
				
			}
		if(none) {
			
			System.out.println("없습니다.");
		}

//			if(birth != null && sdf.format(birth).equals(nowStr)) {
//				
//				String birthStr = sdf.format(birth);
//				if(birthStr.equals(nowStr)) {
//					
//					System.out.println("\n" + friend);
//					searchOk = true;
//					
//				}
//				
//			}
			
			
		}
}
