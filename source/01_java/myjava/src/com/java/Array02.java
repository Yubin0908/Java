package com.java;

public class Array02 {

  public static void main(String[] args) {
    // 정수 배열 선언
    int[] array1 = new int[5];
    // 값 할당
    array1[0] = 1;
    array1[1] = 2;
    array1[2] = 3;
    array1[3] = 4;
    array1[4] = 5;
    // 1, 2, 3, 4, 5 배열 생성
    int[] array2 = new int[] { 1, 2, 3, 4, 5 };
    int[] array3 = { 1, 2, 3, 4, 5 };

    System.out.println("array1의 값 출력");

    for (int i = 0; i < 5; i++) {
      System.out.println(array1[i]);
    }

    System.out.println("array2의 값 출력");

    for (int i = 0; i < 5; i++) {
      System.out.println(array2[i]);
    }

    System.out.println("array3의 값 출력");

    for (int i = 0; i < 5; i++) {
      System.out.println(array3[i]);
    }
  }
}