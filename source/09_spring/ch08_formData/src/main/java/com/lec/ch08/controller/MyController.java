package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	// 모든 요청경로의 페이지에 출력할 내용
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1"); 
		list.add("test2");
		return list;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String input() {		
		return "member/input";
	}
//	@RequestMapping(value="studentId/*", method=RequestMethod.GET)
//	public String studentID(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI(); // /ch08/studentID/aaa
//		String id = uri.substring(uri.lastIndexOf("/") + 1); 
//		id = URLDecoder.decode(id, "UTF-8"); // url에 한글이 들어올경우 인코딩 처리
//		model.addAttribute("id", id);
//		
//		return "studentId";
//	}
	@RequestMapping(value="studentId/{id}", method=RequestMethod.GET)
	public String studentID(@PathVariable("id") String id, Model model) throws UnsupportedEncodingException {
		model.addAttribute("id", id);
		
		return "studentId";
	}
}
