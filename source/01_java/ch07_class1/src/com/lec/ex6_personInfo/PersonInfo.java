package com.lec.ex6_personInfo;

public class PersonInfo {
	
	private String name;
	private int age;
	private char gender;
	public char[] infoPrint;
	
	public PersonInfo() {
		
	}
	public PersonInfo(String name, int age, char gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	public void print() {
		
//		System.out.println(" 이름 = " + name + "\t나이 = " + age + "\t성별 = " + gender);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
//		System.out.println("성별 : " + gender);
		String str = (gender == 'm' || gender == 'M')? " 남 " : (gender == 'f' ? " 여 " : " - ");
		System.out.println("성별 : " + str);
	}
	public String infoPrint() {
		
		String result = " 이름 : " + name + " \n나이 : " + age + " \n성별 : " + str;
		String result = " 이름 : " + name;
		result += " \n나이 : " + age;
		result += " \n성별 : " + str;
		
	}
////	
	
}


