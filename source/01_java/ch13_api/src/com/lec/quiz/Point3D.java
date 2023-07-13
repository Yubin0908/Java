package com.lec.quiz;

public class Point3D {

	private double x;
	private double y;
	private double z;

	public Point3D() {
		
		
	
	}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj instanceof Point3D) {

			Point3D other = (Point3D) obj;

			boolean xChk = (x == other.x);
			boolean yChk = (y == other.y);
			boolean zChk = (z == other.z);

			return xChk && yChk && zChk;

		}
		return false;
	}

	@Override
	public String toString() {

		return "X값 : " + x + "\t Y값 : " + y + "\tz값 : " + z;
	}

}
