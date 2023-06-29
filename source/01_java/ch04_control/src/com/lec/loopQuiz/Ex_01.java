package com.lec.loopQuiz;

//1~10 곱의 결과 출력

public class Ex_01 {

  public static void main(String[] args) {

    int tot = 1; // 누적합 변수

    for (int i = 1; i <= 10; i++) {

        tot = i * tot;
      

    }
    System.out.print("합계 : " + tot);
  }

}
