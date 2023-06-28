package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("지금은 몇 월 인가요? ");

    int season = sc.nextInt();
    // 3월 ~ 5월 봄
    if (season == 0 || season >= 13) {
      System.out.println("잘못된 값입니다.");
    }

    else if (3 <= season && season <= 5) {
      System.out.println("입력하신 달은 봄입니다.");

      // 6월 ~ 8월 여름
    } else if (6 <= season && season <= 8) {
      System.out.println("입력하신 달은 여름입니다.");

      // 9월 ~ 11월 가을
    } else if (9 <= season && season <= 11) {
      System.out.println("입력하신 달은 가을입니다.");

      // 12월 ~ 2월 겨울
    } else if (2 >= season || season == 12) {
      System.out.println("입력하신 달은 겨울입니다.");

    }

  }

}