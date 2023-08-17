package com.lec.condition;

import java.util.Scanner;

public class Ex04_switch_hakjum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("점수(0~100) ? ");

        int score = sc.nextInt();

        switch (score / 10) {

            case 9:
                System.out.println("A");
                break;

            case 8:
                System.out.println("B");
                break;

            case 7:
                System.out.println("C");
                break;

            case 6:
                System.out.println("D");
                break;

            case 5:
                System.out.println("E");
                break;

            default:
                System.out.println("유효하지 않은 점수입니다.");
        }

        sc.close();

    }

}