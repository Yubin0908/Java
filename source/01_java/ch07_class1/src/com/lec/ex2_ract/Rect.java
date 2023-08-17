package com.lec.ex2_ract;
//식별자(클래스명, 패키지명, 변수명) : 알파벳, 숫자, _만 사용, 알파벳으로 시작
//클래스 : 속성(데이터, 인스턴스변수), 메소드 , setter&getter
public class Rect {

	private int width;
	private int height;
	//생성자 함수
	public Rect() {}//Default 생성자 함수(자동생성:컴파일단계에서 생성자 함수가 없을때)
	public Rect(int width, int height ) {
		this.width = width;
		this.height = height;
		
	}
	public Rect(int side) {
		width = height = side;
		
	}
	
	
	public int area() {//녋이를 return
		return width * height;
	
	}
	//setter
	public void setWidth(int width)	{
		this.width = width;
		
	}
	public void setHeight(int height) {
		this.height = height;
		
	}
	//getter
	public int getWidth() {
		return width;
				
	}
	public int getHeight() {
		return height;
		
	}
}
