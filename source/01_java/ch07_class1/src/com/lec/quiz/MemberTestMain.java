package com.lec.quiz;

public class MemberTestMain {

	public static void main(String[] args) {

		Member member = new Member("kim", "jjj", "김길남", "kim@company.com", "서울시 송파구", "2013-12-01", 'm');

		System.out.println(member.infoString());
		System.out.println("=======================");
		int i = 10;
		int[] arr = new int[2];
		arr[0] = 10;
		arr[1] = 20;

		Member[] members = new Member[2];
		members[0] = new Member("hon", "xxx", "홍길동", "hong@company.com", "서울시 강남구", "2000-01-01", 'm');
		members[1] = new Member("ccc", "ddd", "홍길순", "hong1@company.com", "서울시 서초구", "1998-05-31", 'f');

		for (int idx = 0; idx < members.length; idx++) {

			System.out.println(members[idx].infoString());
			System.out.println("=======================");
		}

	}

}
