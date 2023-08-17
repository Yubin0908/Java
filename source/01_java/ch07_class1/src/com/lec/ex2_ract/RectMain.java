package com.lec.ex2_ract;

public class RectMain {

	public static void main(String[] args) {
		
		Rect r1 = new Rect(10, 5);
		Rect r2 = new Rect(7);
		Rect r3 = new Rect();
		r3.setWidth(10);
//		r1.setWidth(10);
//		r1.setHeight(5);
		
//		r2.setWidth(40);
//		r2.setHeight(10);
		System.out.println("r1 : " + r1.getWidth() + " * " + r1.getHeight());
		System.out.println(r1.area());

		System.out.println("r2 : " + r2.getWidth() + " * " + r2.getHeight());
		System.out.println(r2.area());
		System.out.println("r3 : " + r3.getWidth() + " * " + r3.getHeight());
		System.out.println(r3.area());
	}
}
