package com.java;

//강좌(예습) 배열 예제 1
public class Array01 {

  public static void main(String[] args) {

    int[] array1;
    int array2[]; // 배열을 가르킬 수 있는 함수
    int array3[];

    array1 = new int[5];
    array2 = new int[5]; // 배열 인스턴트
    array3 = new int[0];

    System.out.println(array1.length);
    System.out.println(array2.length); // 배열 길이 출력
    System.out.println(array3.length);

  }
}