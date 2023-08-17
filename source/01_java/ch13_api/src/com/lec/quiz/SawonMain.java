package com.lec.quiz;

public class SawonMain {

	public static void main(String[] args) {

		Sawon s1 = new Sawon(200121, "홍길동", "COMPUTER");
		Sawon s2 = new Sawon(200122, "김길동", "DESIGN", 2023, 7, 11);

		Sawon[] sawons = { s1, s2 };

		for (int idx = 0; idx < sawons.length; idx++) {

			System.out.println(sawons[idx]);
			sawons[idx].getSano();

		}

	}

}
