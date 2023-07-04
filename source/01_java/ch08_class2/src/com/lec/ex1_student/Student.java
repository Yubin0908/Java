package com.lec.ex1_student;
//데이터(이름, 국 영 수 총 평 ) 생성자함수, 메소드
public class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	
	public Student() { }
	public Student(String name, int kor, int eng, int math) {
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = kor + eng + math;
		this.avg = tot / 3.0;
		
	}
	public void print() {
		
		System.out.printf("\t%s \t%d \t%d \t%d \t%d \t %.2f\n", name, kor, eng, math, tot, avg);
		
	}
	public String infoString() {
		
		return String.format("\t%s \t%d \t%d \t%d \t%d \t %.2f", name, kor, eng, math, tot, avg);
		
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
	public double getAvg() {
		return avg;
	}
	
}
