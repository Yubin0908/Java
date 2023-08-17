package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SupermarketMng {
	public static void main(String[] args) {

		CustomerDao dao = CustomerDao.getInstance();

		Scanner user = new Scanner(System.in);

		String fn;

		ArrayList<CustomerDto> customers;
		do {
			System.out.print("1: 회원가입, 2: 폰검색, 3: 물품구입, 4: 레벨별출력, 5: 전체출력, 6: 회원탈퇴, 그외 : 종료");
			fn = user.next();

			switch (fn) {

			case "1":
				System.out.print("가입할 회원 핸드폰 번호 : ");
				String ctel = user.next();
				System.out.print("가입할 회원 이름은 : ");
				String cname = user.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS ? "가입성공" : "가입실패");
				break;

			case "2":
				System.out.println("검색할 전화번호(뒤 4자리 또는 전체번호) : ");
				String searchTel = user.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {

					System.out.println(searchTel + "전화번호로 검색된 고객이 없습니다. 회원가입하세요.");
				} else {

					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for (CustomerDto customer : customers) {

						System.out.println(customer);
					}
				}
				break;

			case "3":
				System.out.print("구매할 고객 아이디번호(아이디가 잘못 입력될 경우 구매가 불가) : ");
				int cid = user.nextInt();
				if (dao.getCustomer(cid) != null) {

					System.out.print("구매금액은 : ");
					int price = user.nextInt();
					result = dao.buy(cid, price);

					if (result == CustomerDao.SUCCESS) {

						System.out.println("구매 감사합니다. " + price + "원 구매 후 다음과 같이 고객님의 정보가 수정되었습니다.");
						System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
						System.out.println(dao.getCustomer(cid));
					}

				} else {

					System.out.println(cid + "는 유효한 고객 아이디가 아닙니다.");
				}
				break;

			case "4":
				System.out.println("검색하고자 하는 레벨명 " + dao.getLevelNames() + " 입력 : ");
				String levelName = user.next();
				customers = dao.levelNameGetCustomers(levelName);
				if (customers.isEmpty()) {
					
					System.out.println(levelName + "고객은 존재하지 않습니다."); 
				} else {
					
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						
						System.out.println(customer);
					}
					System.out.println("총 " + customers.size() + "명");
				}
				break;
				
			case "5":
				customers = dao.GetCustomers();
				if (customers.isEmpty()) {
					
					System.out.println("고객이 검색되지 않았습니다.");
				} else {
					
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						
						System.out.println(customer);
						
					
				}
					System.out.println("총 " + customers.size() + "명");
				break;
				}
			case "6":
				System.out.println("탈퇴할 전화번호 입력 : ");
				ctel = user.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS ? "탈퇴완료" : "유효한 전화번호가 아닙니다.");
				break;

			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5")
				|| fn.equals("6"));
		System.out.println("BYE");
	}
}
