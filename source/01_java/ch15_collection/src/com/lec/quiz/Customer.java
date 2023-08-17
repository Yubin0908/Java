package com.lec.quiz;

public class Customer {

	private String name;
	private String tel;
	private String address;

	public Customer(String name, String tel, String address) {

		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	public Customer() {

		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {

		return "\t" + name + "\t" + tel + "\t" + address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
