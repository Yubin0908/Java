package com.lec.loop;

/*  *
    * *
    * * *
    * * * * 
    * * * * *  */
public class Ex03_for_star {

    public static void main(String[] args) {

        for (int i = 5; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {

                System.out.print("* ");

            }

            System.out.println(); // 개행만

        }

    }

}