package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {

	private String name;
	private String address;
	private String tel;
	private Date birth;

	public Friend(String name, String address, String tel) {

		this.name = name;
		this.address = address;
		this.tel = tel;
	}

	public Friend(String name, String address, String tel, Date birth) {

		this.name = name;
		this.address = address;
		this.tel = tel;
		this.birth = birth;

	}

	@Override
	public String toString() {

		if (birth != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

			return "이 름 : " + name + "\n주 소 : " + address + "\n핸드폰 : " + tel + "\n생 일 : " + sdf.format(birth) + "\n";
		}
		return "이 름 : " + name + "\n주 소 : " + address + "\n핸드폰 : " + tel;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	public Date getBirth() {
		return birth;
	}

}
