package com.lec.loop;

public class Ex05_break_continue {
  public static void main(String[] args) {

    for (int i = 1; i <= 10; i++) {

      if (i == 3)

        // break; //반복문 빠져나옴.
        continue; // 증감식으로 감 -> 조건식으로 감

      System.out.println(i);

    }

  }

}