package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
//new Friend("홍", "010-0000-0000", "서울 서대문구", new Date(98, 01, 01));
//new Friend("홍", "010-0000-0000", "서울 서대문구", new Date(new GregorianCalendar(1998, 01, 01).getTimeInMillis()));
public class Friend {

	private String name;
	private String phone;
	private String address;
	private Date birthday;
	
	
	public Friend(String name, String phone, String address, Date birthday) {
		
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		

		return "이 름 : " + name + "\n전화번호 : " + phone + "\n주 소 : " + address + "\n생 일 : " + sdf.format(birthday) + "\n";
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	
	
	
	
	
	
}
