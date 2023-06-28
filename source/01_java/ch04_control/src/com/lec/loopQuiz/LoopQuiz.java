package com.lec.loopQuiz;

import java.util.Scanner;

public class LoopQuiz {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); //
    while (true) {

      int com = (int) (Math.random() * 3); // 1 ~ 3 사이의 난수 발생

      System.out.print("가위(0), 바위(1), 보자기(2) 중에 선택하세요. :  ");

      int you = scanner.nextInt(); // 사용자입력

      if (you == -1) {

        System.out.println("게임이 종료되었습니다.\n");
        break;
      }
      // 컴퓨터 선택 Result
      if (com == 0) {

        System.out.print("컴퓨터가 가위를 냈습니다.\n");

      } else if (com == 1) {

        System.out.print("컴퓨터가 바위를 냈습니다.\n");

      } else if (com == 2) {

        System.out.print("컴퓨터가 보자기를 냈습니다.\n");
      }

      // 유저 선택 Result
      if (you == 0) {

        System.out.print("나는 가위를 냈습니다.\n");

      } else if (you == 1) {

        System.out.print("나는 바위를 냈습니다.\n");

      } else if (you == 2) {

        System.out.print("나는 보자기를 냈습니다.\n");

      } else {
        System.out.print("잘못 입력하였습니다." + "\n");
      }

      // Result

      if (com == you) {

        System.out.println("비겼습니다.\n");

      } else if ((com == 0 && you == 1) || (com == 1 && you == 2) || (com == 2 && you == 1)) {

        System.out.println("이겼습니다.\n");

      } else if ((com == 1 && you == 0) || (com == 2 && you == 1) || (com == 0 && you == 2)) {

        System.out.println("졌습니다.\n");
        break;

      }
    }

    scanner.close();

  }

}