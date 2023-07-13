package com.lec.ex02_protected;

public class ChildIJtestMain {
	public static void main(String[] args) {
		ChildIJ child1 = new ChildIJ(); // 매개변수 없는 부모클래스 생성자->매개변수 없는 자식클래스 생성자
		child1.setI(1); child1.setJ(2);
		child1.sum();
		System.out.println("---------------");
		ChildIJ child2 = new ChildIJ(10, 20);// 매개변수 있는 부모클래스 생성자 -> 매개변수 있는 자식 클래스 생성자
		child2.sum();
	}
}
