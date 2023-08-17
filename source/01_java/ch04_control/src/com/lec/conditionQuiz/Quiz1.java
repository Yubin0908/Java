package com.lec.conditionQuiz;

import java.util.Scanner;

//사용자로부터 수를 입력받아 절대값 출력 (ex.  -5를 입력하면 5를 출력)
public class Quiz1 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("수를 입력하세요.");

    int su = 0;

    int sc = scanner.nextInt();

    if (sc >= 0) {

      System.out.println("입력하신 절대값의 수는 " + su);

    } else {

      System.out.println("입력하신 절대값의 수는 " + (-su));

    }
    scanner.close();
  }

}
