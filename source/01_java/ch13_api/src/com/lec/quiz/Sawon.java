package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

	private int sano;
	private String name;
	private String local;
	private Date indate;

	public Sawon(int sano, String name, String local) {

		this.sano = sano;
		this.name = name;
		this.local = local;
		indate = new Date();

	}

	public Sawon(int sano, String name, String local, int year, int mouth, int day) {

		this.sano = sano;
		this.name = name;
		this.local = local;
		indate = new Date(new GregorianCalendar(year, mouth - 1, day).getTimeInMillis());

	}

//	public String infoString() {
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yy년 M월 dd일");
//		String formatDate = dateFormat.format(indate);
//
//		String result = "[ 사번 ]\t" + sano + "\t";
//		result += "[ 이름 ]\t" + name + "\t";
//		result += "[ 부서 ]\t" + local + "\t";
//		result += " [ 입사일 ]\t " + dateFormat.format(indate);
//
//		return result;
//	}
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		String formatDate = dateFormat.format(indate);
		
		return "[사번]" + sano + "\t[이름]" + name + "\t[부서]" + local + "\t[입사일]" + dateFormat.format(indate);
	}

	public int getSano() {
		return sano;
	}

	public String getName() {
		return name;
	}

	public String getLocal() {
		return local;
	}

	public Date getIndate() {
		return indate;
	}

}
