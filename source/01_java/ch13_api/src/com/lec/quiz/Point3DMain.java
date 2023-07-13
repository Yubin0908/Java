package com.lec.quiz;

import java.text.SimpleDateFormat;

public class Point3DMain {

	public static void main(String[] args) {

		Point3D p1 = new Point3D(3, 5, 2);
		Point3D p2 = new Point3D(3, 5, 2);
		Point3D p3 = new Point3D();

		System.out.println("p1값 >> " + p1);
		System.out.println("p2값 >> " + p2);
		System.out.println("p3값 >> " + p3);
		
		System.out.println("p1 과 p2가 같은 카드인가 : " + p1.equals(p2));

	}



}
