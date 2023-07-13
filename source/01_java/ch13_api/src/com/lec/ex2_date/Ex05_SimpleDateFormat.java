package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormat {

	public static void main(String[] args) {
		
		Date nowDate = new Date();
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar();
		/*
		 *	yyyy(년도4자리) yy(년도2자리) MM(월2자리) M(월1자리) dd(일2자리)  d(일1자리) E(요일)  
		 * a(오전/오후) H(24시단위) h(12시단위) m(분) s(초)
		 * w(올해 몇번째 주인지) W(이번 월 몇번째 주인지) D(올해 몇번쨰 날인지
		 * */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) HH시(a hh시) mm분 ss초");
		
		String nowDateStr = sdf.format(nowDate);
		
		System.out.println(nowDateStr);
		
		String nowCalStr = sdf.format(nowDate.getTime());
		
		System.out.println(nowCalStr);
		
		String nowGcStr = sdf.format(nowGc.getTime());
		
		System.out.println(nowGcStr);
	}
	
}
