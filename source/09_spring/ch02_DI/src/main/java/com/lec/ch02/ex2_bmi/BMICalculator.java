package com.lec.ch02.ex2_bmi;

import lombok.Data;

@Data
public class BMICalculator {
	// 기준점
	private double lowWeight; // 저체중 bmi 지수 기준점
	private double normal; // 정상체중 기준점
	private double overWeight; // 과체중 기준점
	private double obesity; // 비만 기준점
	
	public void bmiCalculator(double weight, double height) {
		double h = height * 0.01;
		double bmi = weight / (h * h);
		System.out.println("BMI 지수는 " + bmi);
		if(bmi <= lowWeight) {
			System.out.println("저체중");
		} else if(bmi <= normal) {
			System.out.println("정상체중");
		} else if(bmi <= overWeight) {
			System.out.println("과체중");
		} else if(bmi <= obesity){
			System.out.println("1단계 비만");
		} else {
			System.out.println("2단계 비만");
		}
	}
}
