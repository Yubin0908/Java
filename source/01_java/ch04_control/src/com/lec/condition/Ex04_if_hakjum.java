package com.lec.condition;

//if문을 이용한 학점출력

import java.util.Scanner;

public class Ex04_if_hakjum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("점수(0~100) ? ");

        int score = sc.nextInt();

        if ((90 <= score) && (score <= 100)) {

            System.out.println("A");

        } else if ((80 <= score) && (score <= 90)) {

            System.out.println("B");

        } else if ((70 <= score) && (score <= 80)) {

            System.out.println("C");
        } else if ((60 <= score) && (score <= 70)) {

            System.out.println("D");

        } else if ((50 <= score) && (score <= 60)) {

            System.out.println("F");
        } else {
            System.out.println("유효하지 않은 점수입니다.");
        }

    }
}
