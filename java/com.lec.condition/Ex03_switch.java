package com.lec.condition;

public class Ex03_switch {

    public static void main(String[] args) {

        int num = 3;

        switch (num) {

            case 1:
                System.out.println("주사위 1");
                break;
            case 2:
                System.out.println("주사위 2");
                break;
            case 3:
                System.out.println("주사위 3");
                break;
            case 4:
                System.out.println("주사위 4");
                break;
            case 5:
                System.out.println("주사위 5");
                break;
            case 6:
                System.out.println("주사위 6");
                break;
        }

        if (num == 1) {
            System.out.println("주사위1");

        } else if (num == 2) {
            System.out.println("주사위2");

        } else if (num == 3) {
            System.out.println("주사위3");

        } else if (num == 4) {
            System.out.println("주사위4");

        } else if (num == 5) {
            System.out.println("주사위5");

        } else if (num == 6) {
            System.out.println("주사위6");
        }
    }
}
