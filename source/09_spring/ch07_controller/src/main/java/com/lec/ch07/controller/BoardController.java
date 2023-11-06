package com.lec.ch07.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//(GET 방식) board/write, board/content, board/list, board.reply
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;
@Controller
@RequestMapping("board") // Common dir
public class BoardController {
	@RequestMapping("write") // MethodRequest 방식은 생략가능. 생략 시, get.Post 모두 사용
	public String write() {		
		return "board/write"; // view : WEB-INF/views/board/write.jsp
	}
	@RequestMapping("content")
	public String content(Model model) {
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member); // 객체 전달
		return "board/content";
	}
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mov = new ModelAndView();
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		list.add(new Member("ccc", "333"));
		mov.addObject("list", list);
		mov.setViewName("board/list");
		return mov;
	}
	public String list(Model model) {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		list.add(new Member("ccc", "333"));
		model.addAttribute("list", list);
		return "board/list";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET) // View
	public ModelAndView reply(ModelAndView mov) {
		Member member = new Member("aaa", "111");
		mov.addObject("member", member);
		mov.setViewName("board/reply");
		return mov;
	}
	
	@RequestMapping(value="reply", method=RequestMethod.POST) // Process
	public String reply(Model model) {
		model.addAttribute("result", "POST.Reply 완료");
		return "board/result";
	}
	
}
