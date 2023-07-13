package com.lec.ex1_string;


public class Ex02_StringApiMethod {

	public static void main(String[] args) {
		
		String str1 = "abcXabc";
		String str2 = "             Ja va           ";
		
		System.out.println("1. " + str1.concat("AAA")); //1. concat (문자열 연결) 											Result : 1. abcXabcAAA
		System.out.println("2. " + str1.substring(3));	  //2. substring (3번째부터 끝까지의 글자 추출)			Result : 2. Xabc
		System.out.println("3. " + str1.substring(0, 5));//3. substring (0번째부터 4번째까지 추출) 				Result : 3. abcXa
		System.out.println("4. " + str1.length()); 		  //4. length (문자열의 길이 추출) 								Result : 4. 7
		System.out.println("5. " + str1.toUpperCase());//5. toUpperCase(대문자로 변환) 								Result : 5. ABCXABC
		System.out.println("6. " + str1.toLowerCase());//6. toLowerCase(소문자로 변환)								Result : 6. abcxabc
		System.out.println("7. " + str1.charAt(3));        //7. charAt(3번째 문자 추출)										Result : 7. X
		System.out.println("8. " + str1.indexOf("b"));   //8. indexOf(처음 나오는 "b"문자 인덱스)					Result : 8. 1
		System.out.println("9. " + str1.lastIndexOf("b")); //9. lastIndexOf(마지막에 나오는 "b"문자 인덱스)   Result : 9. 5
		System.out.println("10. " + str1.indexOf("@"));//10. indexOf(없으면 -1 출력)									Result : 10. -1
		System.out.println("11. " + str1.indexOf("Xabc"));//11. indexOf(처음 나오는 "Xabc"의 시작 인덱스)  Result : 11. 3
/*****************************************************************************************************************************************************************************/
		String str3 =  "abcXabcXabc";
		
		System.out.println("12. " + str3.indexOf('b', 2)); //12. indexOf(2번째 인덱스부터 처음 나오는 'b'의 인덱스)	   Result : 12. 5
		System.out.println("12. " + str3.indexOf("bc", 2)); //12. indexOf(2번째 인덱스부터 처음 나오는 'bc'의 인덱스)  Result : 12. 5
		System.out.println("13. " + str1.equals("abcXabc"));//13. equals(같은 문자인지 확인) 								   	   Result : 13. true
		System.out.println("14. " + str1.equalsIgnoreCase("ABCXABC"));//14. equlalsIgnoreCase(대소문자구분없이비교) Result : 14. true
		System.out.println("15. " + str2.trim()); 			//15. trim(앞뒤 space 제거)													   Result : 15. Ja va
		System.out.println("16. " + str3.replace("abc", "바꿔"));//16. replace(문자대체)											   Result : 16. 바꿔X바꿔X바꿔
/*****************************************************************************************************************************************************************************/		
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		
		
	}
}
