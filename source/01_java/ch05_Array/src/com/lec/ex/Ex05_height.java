package com.lec.ex;

import java.util.Scanner;

//배열을 이용하여 친구들("영희","철수","길동","영수","말자")의 키를 입력받고, 평균키를 출력
//가장 큰 친구와 가장 작은 친구를 출력(이름과 키를 같이 출력  ex. 길동 180)
public class Ex05_height {
	
	public static void main(String[] args) {
		
		String[] Name= {"영희","철수","길동","영수","말자"};
		
		int[] arrHeight = new int[5];
		int[] height = new int[Name.length];
		int totalHeight = 0; //키 누적
		
		Scanner scanner = new Scanner(System.in);
		//키입력받기 -> 키누적
		for(int idx=0; idx < Name.length; idx++) {
			
			System.out.print(Name[idx] + " 의 키는? ");
			
			height[idx] = scanner.nextInt();
			
			totalHeight += height[idx]; //키 누적
			
		}
		
		for(int idx=0; idx < height.length; idx++) {
			
			System.out.print(Name[idx] + "의 키는? " + height[idx] + "\n");
		}
		
		System.out.print("평균키 : ");
		
		System.out.println((double)totalHeight/Name.length);
		
		scanner.close();
		
		//최장신, 최단신 출력	[이름 과 키가 같이 출력]
		int maxIdx = 0, max = 0; //최장신 변수(작은값 초기화)
		int minIdx = 0, min = 999; //최단신 변수 (큰값 초기화)
		
		for(int idx=0; idx < Name.length; idx++) {
			
			if(height[idx] < min ) {
				
				min = height[idx];
				minIdx = idx;								
			}
			if(height[idx] > max) {
				
				max = height[idx];
				maxIdx = idx;
			}
		}
		
		System.out.println("최장신 : " + Name[maxIdx] + " - " + height[maxIdx]);
		System.out.println("최단신 : " + Name[minIdx] + " - " + height[minIdx]);			
	}

}
