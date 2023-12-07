package com.lec.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	
	@GetMapping("/")
	public String index(Model model) {
		log.info("첫 화면으로 이동");
		model.addAttribute("greeting", "Hello, Spring");
		return "index";
	}
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "어서와 부트는 처음이지");
		return "hello";
	}
}
