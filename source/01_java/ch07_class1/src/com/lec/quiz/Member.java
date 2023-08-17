package com.lec.quiz;

public class Member {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	
	public Member() { }
	
	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
		
	}
	
//	public void print() {
//		
//		System.out.println("ID : " + id);
////		System.out.println("Password : " + pw);
//		System.out.println("이름 : " + name);
//		System.out.println("이메일 : " + email);
//		System.out.println("주소 : " + address);
//		System.out.println("생일 : " + birth);
//		System.out.println("성별 : " + gender);
//	}
//	
	public String infoString() {
		
		String str = (gender == 'm')? "남" : (gender == 'f' ? "여" : "-");
		String result = " ID : " + id;
//		result += " \nPassword : " + pw;
		result += " \n이름 : " + name;
		result += " \n이메일 : " + email;
		result += " \n주소 : " + address;
		result += " \n생일 : " + birth;
		result += " \n성별 : " + str;
		return result;
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
}
