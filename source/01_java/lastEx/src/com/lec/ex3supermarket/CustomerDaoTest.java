package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		
		CustomerDao dao = CustomerDao.getInstance();
		
		int result;
		ArrayList<CustomerDto> customer;
		
//		System.out.println("1, 회원가입 테스트");
//		
//		String ctel = "010-0000-7777";
//		String cname = "허길동";
//		
//		result = dao.insertCustomer(ctel, cname);
		
//		System.out.println(result == CustomerDao.SUCCESS ? cname + "님 회원가입 되었습니다. 감사포인트 1000point 적립"
//																	: cname + "님 가입실패");
//	
//		System.out.println("2. 전화번호 검색 테스트");
//		
//		String searchTel = "0000";
//		customer = dao.ctelGetCustomers(searchTel);
//		if(customer.isEmpty()) {
//			
//			System.out.println(searchTel + "전화번호로 검색된 고객이 없습니다.");
//		} else {
//			
//			System.out.println("아이디\t핸드폰번호\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
//			for(CustomerDto customers : customer) {
//				
//				System.out.println(customers);
//			}
//		}
	
		
//		System.out.println("3. 물품구매 테스트");
//		
//		int cid = 5;
//		
//		if (dao.getCustomer(cid) != null) {
//			
//			int price = 500000;
//			result = dao.buy(cid, price); // cid 고객이 price원 물품 구매
//			if (result == CustomerDao.SUCCESS) { // 물품구매성공
//				
//				System.out.println("물품 구매 감사합니다. 고객님의 정보가 아래와 같이 업데이트 되었습니다.");
//				System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
//				System.out.println(dao.getCustomer(cid));
//			} 
//		} else {
//			
//			System.out.println(cid + "는 유효하지 않은 id여서 구매 불가");
//		}
		
		
//		System.out.println("4. 레벨별 출력 테스트");
//		customer = dao.levelNameGetCustomers("normal");
//		
//		if (customer.size() == 0) {
//			
//			System.out.println("해당레벨 고객이 없음");
//		} else {
//			
//			System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
//			for(CustomerDto customers : customer) {
//				
//				System.out.println(customers);
//			}
//		}

		
//		System.out.println("5. 전체 출력 테스트");
//		customer = dao.GetCustomers();
//		
//		if (customer.size() == 0) {
//			
//			System.out.println("해당레벨 고객이 없음");
//		} else {
//			
//			System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
//			for(CustomerDto customers : customer) {
//				
//				System.out.println(customers);
//			}
//		}
		
		
		System.out.println("6. 회원탈퇴 테스트");
		
		result = dao.deleteCustomer("010-0000-0000");
		
		System.out.println(result == CustomerDao.SUCCESS ? "삭제성공" : "유효한 번호가 아닙니다.");
	
	}
}
