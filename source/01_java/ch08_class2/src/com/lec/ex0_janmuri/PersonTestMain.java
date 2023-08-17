package com.lec.ex0_janmuri;
class PersonInfo{
	
	private String name;
	private int age;
	private char gender;
	
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		
		System.out.println("이름 : " + name + ", 나이 : " + age + ", 성별 : " + gender);
		
	}
	
	
}
public class PersonTestMain {

	public static void main(String[] args) {
		
		PersonInfo person1 = new PersonInfo("홍길동", 22, 'm');
		
		person1.print();
		
	}
}
