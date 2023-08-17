package com.lex.ex3_squaer;
//속성, [생성자함수,] 메소드, [setter & getter]
public class Square {
	
	private int side;
	
	public Square() {//생성자 함수 : return타입이 없고 클래스명과 같은 이름의 함수
		System.out.println("매개변수 없는 생성자 함수 호출");
		
	}
	public Square(int side) {//생성자 함수의 용도 : 데이터 초기화
		this.side = side;
		
		System.out.println("매개변수 있는 생성자 함수 호출");
		
	}
	public int area() {
		return side * side;
		
	}
	public void setSide(int side) {
		this.side = side;
		
	}
	public int getSide() {
		return side;
		
	}
	
}
