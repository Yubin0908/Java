package com.lec.quiz;

public class StudentMain {

	public static void main(String[] args) {

		Student s1 = new Student( "정우성", 90, 80, 90);
		Student s2 = new Student( "김하늘", 100, 80, 95);
		Student s3 = new Student( "황정민", 95, 80, 90);
		Student s4 = new Student( "강동원", 95, 90, 99);
		Student s5 = new Student( "마동석", 90, 90, 90);

		Student[] students = { s1, s2, s3, s4, s5 };




		String[] title = { "번호", "이름", "국어", "영어", "수학", "총점", "평균" };
		int[] total = new int[5];

		line();

		System.out.println();
		System.out.println("\t\t\t\t  ☆  성 적 표  ☆ ");

		line('-');

		System.out.println();
		for (String t : title) {
			System.out.print(" \t " + t);
		}

		System.out.println();

		for (int idx = 0; idx < students.length; idx++) {
			System.out.println(students[idx].infoString());
			
			
			total[0] += students[idx].getKor();
			total[1] += students[idx].getEng();
			total[2] += students[idx].getMath();
			total[3] += students[idx].getTot();
			total[4] += students[idx].getAvg();
			
			
		}
		line('-');
		
		System.out.println();
		System.out.println("\t\t총점 \t " + total[0] + "\t" + total[1] + "\t" + total[2] + "\t" + total[3] + "\t" + total[4]);
		
		System.out.println();
		System.out.print("\t\t평균");
		
		for (int tot : total) {

			System.out.printf("\t%d", tot / students.length);

		}
		System.out.println();
		line();



	}

	private static void line(char c) {
		for (int i = 0; i < 65; i++) {
			System.out.print(c);
		}
	}

	private static void line() {
		for (int i = 0; i < 65; i++) {
			System.out.print('■');
		}
	}
}
