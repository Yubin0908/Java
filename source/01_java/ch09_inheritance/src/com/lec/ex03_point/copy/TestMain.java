package com.lec.ex03_point.copy;
public class TestMain {
	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point(1,2);
		point1.infoPrint();
		point2.infoPrint();
		System.out.println("point1과 point2가 같은지 여부 : " + point1.equals(point2));
		System.out.println("----------------------");
		Point3D point3d = new Point3D(10,20,30);
		point3d.infoPrint(); 
		//point3d.infoPrint3d();
	}
}
