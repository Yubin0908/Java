package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerArrayListMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Customer> customers = new ArrayList<>();
		String inputdata, name, tel, address;

		while (true) {
			System.out.print("회원정보를 입력하시겠습니다( y / n ) ?  >>");
			inputdata = sc.nextLine();

			if (inputdata.equalsIgnoreCase("n"))
				break;

//			System.out.print("이름 >> ");
//			name = sc.nextLine();
//
//			System.out.print("전화번호 >> ");
//			tel = sc.nextLine();
//
//			System.out.println("주소 >> ");
//			address = sc.nextLine();
//
//			customers.add(new Customer(name, tel, address));
			
			Customer customer = new Customer();
			
			System.out.print("이름 ?");
			customer.setName(sc.nextLine());
			
			System.out.print("전화 ?");
			customer.setTel(sc.nextLine());
			
			System.out.print("주소 ?");
			customer.setAddress(sc.nextLine());
			
			customers.add(customer);
			
		}
		if (customers.size() == 0) {

			System.out.println("가입한 회원이 없습니다.");

		} else {

			for (Customer customer : customers) {

				System.out.println(customer);

			}

		}
	}

}
