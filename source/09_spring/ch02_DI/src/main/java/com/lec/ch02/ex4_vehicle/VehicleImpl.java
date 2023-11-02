package com.lec.ch02.ex4_vehicle;

import lombok.Data;

@Data
public class VehicleImpl implements Vehicle {
	private String vehicle;
	private int speed;
	
	public void ride(String name) {
		System.out.println(name + " 은(는) " + vehicle + " 를(을) " + speed + "km/h 속도로 탄다.");
	}
}
