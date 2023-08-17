package com.lec.condition;
//정수 할당 후 점수에 따른 결과를 출력
public class Ex01_if {

	public static void main(String[] args) {
		
		int score = 65;
		
		if( score >= 90 )
		{ 
			System.out.println( "완벽합니다." ); 
	 
		}else if( score >= 70 ){
	  	 System.out.println( "완벽하지 않음" );
	   
		}else if( score >= 60 ) {
			 System.out.println( " 분발하시던지");
			 
	}
	   
	   System.out.println( "DONE" );
	
	   
	}
}
