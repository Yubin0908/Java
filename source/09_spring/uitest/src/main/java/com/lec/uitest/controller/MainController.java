package com.lec.uitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.uitest.dto.StudentDto;

@Controller
public class MainController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@RequestMapping(value="input", method=RequestMethod.GET)
	public String input() {
		return "student/input";
	}
	@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(@ModelAttribute("student") StudentDto studentDto) {
		return "student/result";
	}
}
