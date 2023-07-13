package com.lec.ex4_object;

import com.lec.quiz.Sawon;

public class Ex1_PersonMain {

	public static void main(String[] args) {
		
		Person p1 = new Person(9812121012012L);
		Person p2 = new Person(9812121012012L);
		Person p3 = null;
		Sawon s = new Sawon(1, "박", "COM");
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("p1==p2 는 " + ( p1 == p2));
		System.out.println("p1과 p2가 같나 : " + p1.equals(p2));
		System.out.println("p1과 p3가 같나 : " + p1.equals(p3));
		System.out.println("p2과 s가 같나 : " + p2.equals(s));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
	
}
