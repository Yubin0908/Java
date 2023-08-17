package com.lec.ex3_math;

import java.util.Random;

//0 <= Math.random() < 1 실수
//0 <= Math.random()*3 < 3 실수
// 0 <= (int)(Math.random()*3) < 3 정수
public class Ex03_random {
	
	public static void main(String[] args) {
		
		System.out.println("1~45까지의 정수 난수 : " + ((int)(Math.random()*45) + 1));
		System.out.println("0~2까지의 정수 난수 : " + (int)(Math.random()*3));
		
		Random random = new Random();
		
		System.out.println("int 정수 난수 >> " + random.nextInt());
		System.out.println("double 정수 난수 >> " + random.nextDouble());
		System.out.println("true/false 난수 >> " + random.nextBoolean());
		
		System.out.println("0~100까지의 정수 난수 >> " + random.nextInt(101));
		System.out.println("0~2까지의 정수 난수 >> " + random.nextInt(3));
		System.out.println("1~45까지의 정수 난수 >> " + random.nextInt(45 + 1) );
	}
	
}
