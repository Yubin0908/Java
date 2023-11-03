package com.lec.ch04.ex2_life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Data;

@Data
public class OtherPerson {
	private String name;
	private String tel;
	
	@PostConstruct
	public void initMethod() {
		System.out.println("※ OtherPerson 객체 생성 시 호출 : initMethod()");
	}
	@PreDestroy
	public void preDestroy() {
		System.out.println("※ OtherPerson 객체 소멸 시 호출 : preDestroy()");
	}
}
