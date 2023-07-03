package com.lec.ex4;

import com.lex.ex4_human.*;
import com.lex.ex4_human.kid.Kid;

public class HumanMain {

	public static void main(String[] args) {
		
		Woman woman1 = new Woman();
		Woman woman2 = new Woman();
		
		System.out.println("woman1과 woman2가 같은지 : " + (woman1 == woman2)); 
		System.out.println("woman1과 woman2가 같은지 : " + woman1.equals(woman2));
		
		
		Man man = new Man();
		
		Man kim = new Man("홍길동", 22, 170, 59);
		Man sin = new Man("신길동");
		Man kim2 = kim;
		
		System.out.println("kim과 kim2가 같은지 여부 : " + kim.equals(kim2));
		
		sin.setHeight(165);
		sin.setWeight(57);
		
		System.out.println("kim의 bmi 지수 : " + kim.calculateBMI());
		System.out.println("sin의 bmi 지수 : " + sin.calculateBMI());		
		
		
		
		
		
		
		
		
		

//		Kid kid2 = new Kid();
	}
	
}
