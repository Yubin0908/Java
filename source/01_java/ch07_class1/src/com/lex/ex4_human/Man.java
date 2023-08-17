package com.lex.ex4_human;
//Man kim = new Man("홍길동", 22, 180, 68); 생성자함수의 오버로딩
//Man kim = new Man();
public class Man {

	private String name;
	private int age;
	private int height;
	private double weight;
	
	//개발자가 생성자 함수를 하나이상 만들면 컴파일러는 디폴트 생성자 함수를 생성 하지 않음.
	public Man() {
		
		System.out.println("매개변수가 없는 Man 생성자 함수");
	}
	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		
		System.out.println("데이터4개 초기화하는 Man 생성자 함수");
		
	}

	public Man(String name) {
		this.name = name;
		
		System.out.println("이름을 초기화하는 Man 생성자 함수");

	}
	public Man(int height) {
		this.height = height;
		
		System.out.println("키를 초기화하는 Man 생성자 함수");
	}
	public Man(double weight) {
		this.weight = weight;
		
		System.out.println("몸무게를 초기화하는 Man 생성자 함수");
	}
	
	//메소드 : 입력된 키와 몸무게를 이용해서 BMI지수를 return하는 메소드 180/68.1 => 68.1/(1.8*1.8)
	public double calculateBMI()	{//객제안의 height와 weight를 이용해서 BMI지수 return
		double result = weight / ((height * 0.01) * (height * 0.01));
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	
}

