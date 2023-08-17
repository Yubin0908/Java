package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		String inputdata, name, tel, address;

		while (true) {

			System.out.print("회원정보를 입력하시겠습니다( y / n) ? ");

			inputdata = sc.nextLine();

			if (inputdata.equalsIgnoreCase("n"))
				break;

			System.out.print("이름 : ");
			name = sc.nextLine();

			System.out.print("전화번호 : ");
			tel = sc.nextLine();

			System.out.print("주소 : ");
			address = sc.nextLine();

			customers.put(name, (new Customer(name, tel, address)));

		}
		if (customers.size() == 0) {

			System.out.println("가입한 회원이 없습니다.");
		} else {
			Iterator<String> iterator = customers.keySet().iterator();

			while (iterator.hasNext()) {

				String customer = iterator.next();
				System.out.println(customers.get(customer));

			}
		}

	}
}
