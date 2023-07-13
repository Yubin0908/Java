package com.lec.ex03_point.copy;
// x, y / infoPrint(��ǥ x,y) setter & getter ��ӹ���
// Point3D p = new Point3D(1,2,3); p.infoPrint()
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("�Ű����� �ִ� Point3D������ - x,y,z�ʱ�ȭ");
	}
	@Override
	public void infoPrint() {
		System.out.println("��ǥ(x,y,z) : " + getX() + "," + getY() + "," + z);
	}
//	public void infoPrint3d() {
//		System.out.println("��ǥ(x,y,z) : " + getX() + "," + getY() + "," + z);
//	}
}
