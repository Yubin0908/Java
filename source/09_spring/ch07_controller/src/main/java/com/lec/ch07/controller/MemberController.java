package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;
// member?method=join, member?method=login, member?method=logout, member?method=modify
@Controller 
@RequestMapping("member")
public class MemberController {
	@RequestMapping(params = "method=join", method=RequestMethod.GET) // 파라미터 기준 
	public String join(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	@RequestMapping(params = "method=join", method=RequestMethod.POST)
	public ModelAndView join(ModelAndView mov) {
		mov.addObject("kind", "회원가입 (완료)");
		mov.setViewName("member/result");
		return mov;
	}
	@RequestMapping(params = "method=login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("kind", "로그인");
		return "member/result";
	}
	@RequestMapping(params = "method=logout", method=RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("kind", "로그아웃");
		return "member/result";
	}
	@RequestMapping(params = "method=modify", method=RequestMethod.GET)
	public String modifyView(Model model) {
		model.addAttribute("member", new Member("ddd", "444"));
		return "member/modify";
	}
	@RequestMapping(params = "method=modify", method=RequestMethod.POST)
	public String modify(Model model) {
		model.addAttribute("kind", "멤버 수정 완료");
		return "member/result";
	}
}
