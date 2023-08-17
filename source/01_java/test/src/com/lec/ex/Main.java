package com.lec.ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");


        StringBuilder sb = new StringBuilder();
        sb.append(input[0]);
        sb.reverse();
        int A = Integer.parseInt(sb.toString());

        sb.setLength(0);

        sb.append(input[1]);
        sb.reverse();
        int B = Integer.parseInt(sb.toString());

        if(A>B){
            System.out.println(input[0]);
        } else {
            System.out.println(input[1]);
        }
    }
}
