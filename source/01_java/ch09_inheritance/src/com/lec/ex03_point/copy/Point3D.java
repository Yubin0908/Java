package com.lec.ex03_point.copy;
// x, y / infoPrint(좌표 x,y) setter & getter 상속받음
// Point3D p = new Point3D(1,2,3); p.infoPrint()
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("매개변수 있는 Point3D생성자 - x,y,z초기화");
	}
	@Override
	public void infoPrint() {
		System.out.println("좌표(x,y,z) : " + getX() + "," + getY() + "," + z);
	}
//	public void infoPrint3d() {
//		System.out.println("좌표(x,y,z) : " + getX() + "," + getY() + "," + z);
//	}
}
