package com.lec.loopQuiz;

//사용자에게 입력받아 해당값 출력

public class Ex_02 {

  public static void main(String[] args) {

    int tot = 0; // 누적합 변수

    for (int i = 1; i <= 10; i++) {

      if (i % 2 == 1) {

        tot = tot + i;
      }

    }
    System.out.print("합계 : " + tot);
  }

}
