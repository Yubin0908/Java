package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {

	private String name;
	private String tel;
	private Date birthStr;
	private String address;

	public Member(String name, String tel, Date datedateBirth, String address) {

		this.name = name;
		this.tel = tel;
		this.birthStr = datedateBirth;
		this.address = address;

	}

	public Member() {

	}

	@Override
	public String toString() {

		if (birthStr != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

			return name + "\t\t" + tel + "\t\t" + sdf.format(birthStr) + "\t" + address + "\n";
		}
		return  name + "\t " + tel + "\t" + address + "\n";
	}
}
