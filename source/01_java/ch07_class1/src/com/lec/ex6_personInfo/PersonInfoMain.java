package com.lec.ex6_personInfo;

public class PersonInfoMain {

	public static void main(String[] args) {
		
		
		int i = 10;
		
		// int[] arr = {10, 20, 30};
		
		int[] arr = new int[3];
		
		arr[0]=10; arr[1]=20; arr[2]=30;
		
		PersonInfo p1 = new PersonInfo("홍길동", 20, 'm');
		
//		PersonInfo[] person = {new PersonInfo("홍길순", 22, 'f'), 
//								p1,
//								new PersonInfo("신길동", 33, 'm')};
		PersonInfo[] person = new PersonInfo[3];
		
		person[0] = new PersonInfo("홍길순", 22, 'f');
		
		person[1] = p1;
		
		person[2] = new PersonInfo("신길동", 33, 'm');
		
		for(PersonInfo p : person) {
			
			System.out.println(p.infoPrint());
			
		}
		
	}
	
}

