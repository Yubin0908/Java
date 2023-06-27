package com.lec.ex;

public class VarEx04 {

	public static void main(String[] args) {
		
		int i = 40; 
		long l = 2200000000L;
		
		System.out.println("l = " + l);
		
		boolean b = true;
		
		System.out.println("b =" + b);
		
		float f = 3.1415926539F;
		double d = 3.1415926539;
		
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		
		if (f == d) {
			System.out.println("f와 d가 같다.");
			
		}else {
				System.out.println("f와  d가 다르다");
			}
		
		d = 3;
		
		double result = d+ 1;
		
		System.out.println("d+1 = " + result);
		
		i = 3;
		
		System.out.println("i/2 = " + (i/2));
		System.out.println("(double)i/2 =" + ((double)i/2));
		System.out.println("i/2.0 = " + i/2.0);
	
	}
}

