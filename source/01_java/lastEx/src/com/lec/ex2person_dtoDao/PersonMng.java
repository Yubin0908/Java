package com.lec.ex2person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		
		PersonDao dao = PersonDao.getInstance();
		
		Scanner user = new Scanner(System.in);
		
		String fn;
		ArrayList<String> jobs = dao.jnameList();
		
		do {
			System.out.print("1: 입력 || 2: 직업별출력 || 3: 전체출력 || 그외: 종료");
			fn = user.next();
			switch(fn) {
			case "1": 
				System.out.print("입력할 이름 : ");
				String pname = user.next();
				
				System.out.print("입력할 직업명" +jobs+ " : ");
				String jname = user.next();
				
				System.out.print("입력할 국어점수 : ");
				int kor = user.nextInt();
				
				System.out.print("입력할 영어점수 : ");
				int eng = user.nextInt();
				
				System.out.print("입력할 수학점수 : ");
				int mat = user.nextInt();
				
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				
			break;
			
			case "2":
				System.out.println("출력할 직업명  " + jobs + "  은?");
				jname = user.next();
				
				ArrayList<PersonDto> dtos = dao.selectJname(jname);
				
				if(dtos.isEmpty()) {
					
					System.out.println(jname + "직업의 사람이 없습니다.");
					
				} else {
					
					for (PersonDto dto : dtos) {
						
						System.out.println(dto);
					}
				}
				
			break;
			
			case "3":
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					
					System.out.println("등록된 사람이 없습니다.");
					
				} else {
					
					for(int idx = 0; idx < dtos.size(); idx++) {
						
						System.out.println(dtos.get(idx));
					}
					System.out.println("\t===============총" + dtos.size() + "명===============");
				}
				
				
				
		}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
		
	}
}
