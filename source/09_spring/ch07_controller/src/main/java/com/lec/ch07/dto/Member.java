package com.lec.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String pw;
	
	@Override
	public String toString() {
		return "아이디 : " + id + " // 비밀번호 : " + pw;
	}
	
	
}
