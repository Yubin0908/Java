package com.lec.ch09.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
//	@RequestMapping(value="student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod(); // GET 또는 POST
//		logger.info("요청 방식 : " + method);
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentid";
//	}
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String student(String id, Model model) {
		logger.info("요청 방식 : GET");
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentid";
	}
	@RequestMapping(value="student", method=RequestMethod.POST)
	public String student(Model model, String id) {
		logger.info("요청 방식 : POST");
		model.addAttribute("method", "POST");
		model.addAttribute("id", id);
		return "studentid";
	}
	@RequestMapping(value="studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentOk", method=RequestMethod.POST)
	public String studentOkPost() {
		return "studentOk";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.POST)
	public String studentNgPost() {
		return "studentNg";
	}
	@RequestMapping(value="idConfirm", method=RequestMethod.POST)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			// 제대로된 ID를 입력한 경우 "studentOk.do" 요청
			// return "redirect:studentOk.do"; // 새로운 request객체로 studentOk.do 요청 (GET)
			return "forward:studentOk.do"; // request객체를 새로 생성하지 않고, studentOk 요청 (POST)
		} else {
			// return "redirect:studentNg.do"; // 새로운 request객체로 studentNg.do 요청 (GET)
			return "forward:studentNg.do"; // request객체를 새로 생성하지 않고, studentNg 요청 (POST)
		}
	}
	@RequestMapping(value="fullPath", method=RequestMethod.GET)
	public String fullPath() {
		// return "redirect:http://naver.com/";
		return "redirect:temp/temp.jsp";
	}
}
