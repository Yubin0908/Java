package com.lec.loopQuiz;

//사용자에게 입력받아 해당값 출력
import java.util.Scanner;

public class Gugudan_03 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // user Input
    System.out.print("원하는 값을 입력하세요 :  ");

    int user = sc.nextInt();

    for (int i = 1; i <= 9; i++) {

      // data output
      System.out.println(user + " * " + i + " = " + user * i);

    }

  }

}
