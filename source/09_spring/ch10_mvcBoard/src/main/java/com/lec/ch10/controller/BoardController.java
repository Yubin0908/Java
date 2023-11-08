package com.lec.ch10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.service.BContentService;
import com.lec.ch10.service.BDeleteService;
import com.lec.ch10.service.BListService;
import com.lec.ch10.service.BModifyReplyViewService;
import com.lec.ch10.service.BModifyService;
import com.lec.ch10.service.BReplyService;
import com.lec.ch10.service.BWriteService;
import com.lec.ch10.vo.BoardDto;
// board/list.do, board/write.do, board/content.do, board/modify.do, board/delete.do, board/reply.do
@Controller @RequestMapping("board")
public class BoardController {
	@Autowired
	private BListService bListService;
	@Autowired
	private BWriteService bWriteService;
	@Autowired
	private BContentService bContentService;
	@Autowired
	private BModifyReplyViewService bModifyReplyViewService;
	@Autowired
	private BModifyService bModifyService;
	@Autowired
	private BDeleteService bDeleteService;
	@Autowired
	private BReplyService bReplyService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(String page, Model model) {
		// board/list.do?page=10 또는 board/list.do
		model.addAttribute("page", page); // 서비스에 전달하기 위해 model에 page 번호 전달 ( cf. : null 이거나 page 번호 )
		bListService.execute(model);
		return "board/list";
	}
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute("board") BoardDto boardDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		bWriteService.execute(model);
		return "forward:list.do";
	}
	// content.do?bid=4&page=1(list.jsp에서 진입)
	// content.do?bid=4&page=1&after=u(modify에서 진입)
	@RequestMapping(value="content", method= {RequestMethod.GET, RequestMethod.POST})
	public String content(Model model, int bid, String after) { 
		model.addAttribute("bid", bid);
		model.addAttribute("after", after);
		bContentService.execute(model);
		return "board/content";
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modify(int bid, Model model) {
		model.addAttribute("bid", bid);
		bModifyReplyViewService.execute(model);
		return "board/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Model model, @ModelAttribute("board") BoardDto boardDto, HttpServletRequest request) {
		model.addAttribute("request", request);
		bModifyService.execute(model);
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		bDeleteService.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("bid", bid);
		bModifyReplyViewService.execute(model);
		return "board/reply";
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(@ModelAttribute("board") BoardDto boardDto, Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		bReplyService.execute(model);
		return "forward:list.do";
	}
	
}
