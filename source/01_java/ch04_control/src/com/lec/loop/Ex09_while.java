package com.lec.loop;

// 1~10까지 숫자 중 3의 배수들의 합을 출력
public class Ex09_while {

    public static void main(String[] args) {

        int tot = 0;
        int i = 1; // 초기값

        while (i <= 10) {

            if (i % 3 == 0) {

                tot += i;
            }
            i++;
        }
        System.out.println("1~10까지 3의 배수의 합 : " + tot);

    }
}