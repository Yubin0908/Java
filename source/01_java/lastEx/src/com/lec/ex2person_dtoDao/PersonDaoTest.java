package com.lec.ex2person_dtoDao;

import java.util.ArrayList;

public class PersonDaoTest {
	public static void main(String[] args) {

		PersonDao dao = PersonDao.getInstance();

		System.out.println("직업명들 : " + dao.jnameList());

//		System.out.println("1번 기능 insert 테스트");
//		
//		PersonDto dto = new PersonDto("홍홍홍", "배우", 80, 80, 60);
//		dao.insertPerson(dto);

		System.out.println("2. 직업별 출력 테스트");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		if (dtos.isEmpty()) {

			System.out.println("배우 직업의 사람이 등록되지 않았습니다.");
		} else {

			for (PersonDto d : dtos) {

				System.out.println(d);

			}
		}
		System.out.println("2-1. 개그맨 출력 테스트");
		dtos = dao.selectJname("개그맨");
		if (dtos.size() == 0) {

			System.out.println("개그맨 직업의 사람이 등록되지 않았습니다.");
		} else {

			for (PersonDto d : dtos) {

				System.out.println(d);

//			for (int idx = 0; idx < dtos.size(); idx++ ) {
//				
//				System.out.println(dtos.get(idx));
//			}				
			}
		}
		System.out.println("3. 전체 출력 테스트");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {

			System.out.println("등록된 사람이 없습니다.");
		} else {
//			
//			for (PersonDto d: dtos) {
//				
//				System.out.println(d);
//			}
			for (int idx = 0; idx < dtos.size(); idx++) {
				
				System.out.println(dtos.get(idx));
				if(idx%3 == 2) {
					
					System.out.println("------------------------------------------------------");
				}
				
			}
		}
	}
}
