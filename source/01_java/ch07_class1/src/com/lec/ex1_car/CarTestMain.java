package com.lec.ex1_car;

public class CarTestMain {

	public static void main(String[] args) {
		
		Car myPorsche = new Car();
		myPorsche.setColor(" 빨강 ");
		myPorsche.setCc(3000);
		
//		System.out.println(myPorsche.color + "색 차 " + myPorsche.cc + "cc, 속도 :" + myPorsche.speed);
		System.out.println(myPorsche.getColor() + "색 차 " + myPorsche.getCc() + "cc, 속도 :" + myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("Gray");
		yourPorsche.drive();
		
//		System.out.println(yourPorsche.color + "색 차 " + yourPorsche.cc + "cc, 속도 :" + yourPorsche.speed);
		System.out.println(yourPorsche.getColor() + "색 차 " + yourPorsche.getCc() + "cc, 속도 :" + yourPorsche.getSpeed());
	}
}
