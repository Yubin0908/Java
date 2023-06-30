package com.lec.ex;
//다중배열
public class Ex06_multiDemension {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3}; //1차원 배열 
		System.out.println(arr[2]);
		
		int[][] test = {{1, 2, 3}, {1, 2, 3}};
				
		System.out.println(test[0][1]);
		// 다차원 출력
		for(int i =0; i<test.length; i++) {
			
			for(int j=0; j < test[i].length; j++) {
				
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
				
			}
			
		}
	}

}
