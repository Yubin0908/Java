package com.lec.ex;
// 일반for문 vs. 확장for문(Array, ArrayList에서만)
public class Ex02_out {

	public static void main(String[] args) {
		
		double[] arr = {999.0, 987.0, 920.0};//new double[3]; // {0, 0, 0}
		
		//일반for문(배열출력-인덱스와 같이 츨력)
		for(int idx=0; idx < arr.length; idx++) {
			
			System.out.printf("arr[%d] = %f\t", idx, arr[idx]);
		}
		//확장for문(배열 출력-배열 값만(출력만 가능)
		for(double a : arr) {
			
			System.out.println(a);			
		}		
		//배열 값을 변경[10% 인상]
		//일반for문 사용[확장for문을 이용할 시, 값이 변경 안됨]
		for(int idx=0; idx < arr.length; idx++) {
			
			arr[idx] *= 1.1;
			
		}

		for(double a : arr) {
			
			System.out.println(a + "\t");
			
		}
	}
}
