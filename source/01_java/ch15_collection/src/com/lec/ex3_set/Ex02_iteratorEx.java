package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

// iterator : 모든 컬렉션 자료구조에서 사용가능
public class Ex02_iteratorEx {

	public static void main(String[] args) {
		//1. list
		ArrayList<String> list	= new ArrayList<>();
		list.add("sample1"); list.add("sample2");
		
		for(String l : list) {
			
			System.out.println(l);
		}

		//2. map
		System.out.println("===========================");
		HashMap<String, Friend> map = new HashMap<>();
		
		map.put("홍길동", new Friend("홍길동", "010-9999-9999"));
		map.put("김길동", new Friend("김길동", "010-8888-8888"));
		
		Iterator<String> iterator = map.keySet().iterator()	;
		
		while(iterator.hasNext()) {
			
			String key = iterator.next();
			System.out.println(key + " : " + map.get(key));
			
		}
		//3. set
		System.out.println("===========================");
		HashSet<Friend> set = new HashSet<Friend>();
		
		set.add(new Friend("홍길동", "010-9999-9999"));
		set.add(new Friend("김길동", "010-8888-8888"));
		
		Iterator<Friend> iterator2 = set.iterator();
		
		while(iterator2.hasNext()) {
			
			System.out.println(iterator2.next());
		}
	}
	
}
