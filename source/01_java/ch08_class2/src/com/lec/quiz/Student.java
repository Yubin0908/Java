package com.lec.quiz;

public class Student {

	private int studentNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int avg;
	
	public static int count = 0;
	
	public Student() {
		
		count = ++studentNo;
	}
	
	public Student( String name, int kor, int eng, int math) {
		count++;
		this.studentNo = count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = kor + eng + math;
		this.avg = tot / 3;
	}

	public String infoString() { 
		
		return String.format("\t%d \t%s \t%d \t%d \t%d \t%d \t %d\n", studentNo, name, kor, eng, math, tot, avg);
		
	}
	public int getStudentNo() {
		return studentNo;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public int getAvg() {
		return avg;
	}



	
	
}
