package com.lec.loop;

/* 		i가 1일 때 누적합은 1이다
		i가 2일 때 누적합은 3이다 */
public class Ex08_while {

    public static void main(String[] args) {

        int tot = 0;
        int i = 1;

        /*
         * for (int i = 1; i <= 10; i++) {
         * 
         * tot += i;
         * 
         * System.out.printf("i가 %d일 떄까지 누적합은 %d이다.\n", i, tot);
         */

        while (i < 10) {

            tot += i;

            System.out.printf("i가 %d일 떄까지 누적합은 %d이다.\n", i, tot);

            i++;
        }

    }

}
