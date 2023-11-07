package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("member")
public class MemberController {
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
	@RequestMapping(value="join1", method=RequestMethod.POST)
	public String join1(HttpServletRequest request, Model model) {
		// Parameter를 받아 model에 add
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		model.addAttribute("result", "join1_Result");
		
		return "member/result1";
	}
	@RequestMapping(value="join2", method=RequestMethod.POST)
	public String join2(@RequestParam("name") String mName, @RequestParam("id") String mId, @RequestParam("pw") String mPw, @RequestParam("age") int mAge, 
						@RequestParam("email") String mEmail, @RequestParam("address") String mAddress, Model model) {
		model.addAttribute("name", mName);
		model.addAttribute("id", mId);
		model.addAttribute("pw", mPw);
		model.addAttribute("age", mAge);
		model.addAttribute("email", mEmail);
		model.addAttribute("address", mAddress);
		model.addAttribute("result", "join2_Result");
		return "member/result1";
	}
	@RequestMapping(value="join3", method=RequestMethod.GET)
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		model.addAttribute("result", "join3_Result");
		return "member/result1";
	}
	@RequestMapping(value="join4", method=RequestMethod.GET)
	public String join4(MemberDto memberDto, Model model) {
		model.addAttribute("result", "join4_Result");
		model.addAttribute("member", memberDto);
		return "member/result4";
	}
//	public String join4(String name, String id, String pw, int age, String email, String address, Model model) {
//		model.addAttribute("result", "join4_Result");
//		MemberDto member = new MemberDto();
//		member.setId(id);
//		member.setName(name);
//		member.setPw(pw);
//		member.setEmail(email);
//		member.setAge(age);
//		member.setAddress(address);
//		model.addAttribute("member", member);
//		return "member/result1";
//	}
	@RequestMapping(value="join5", method=RequestMethod.GET)
	public String join5(MemberDto memberDto) {
		
		return "member/result5";
	}
	@RequestMapping(value="join6", method=RequestMethod.GET)
	public String join6(@ModelAttribute("member") MemberDto memberDto) { // parameter 받아 객체 생성 후 model에 add
		
		return "member/result4";
	}
	
	
}
