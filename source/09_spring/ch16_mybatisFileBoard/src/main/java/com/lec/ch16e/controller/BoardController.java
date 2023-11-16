package com.lec.ch16e.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch16e.service.BoardService;
import com.lec.ch16e.util.Paging;
import com.lec.ch16e.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="boardList", method= {RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		Paging paging = new Paging(boardService.getBoardTotCnt(), pageNum, 10, 5);
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardService.boardList(paging));
		return "board/list";
	}
	@RequestMapping(value="content", method= {RequestMethod.GET, RequestMethod.POST})
	public String boardContent(int bid, Model model) {
		model.addAttribute("contentBoard", boardService.boardInfo(bid, null));
		return "board/content";
	}
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String boardWriteView() {
		return "board/write";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String boardWrite(Board board, Model model, HttpServletRequest request) {
	//	model.addAttribute("writeResult", boardService.boardWrite(board, request, null));
		return "forward:boardList.do";
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String boardModifyView(int bid, Board board, Model model) {
		model.addAttribute("modifyBoard", boardService.boardModifyReplyView(bid));
		return "board/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String boardMOdify(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("modifyResult", boardService.boardModify(board, request));
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String boardDelete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:boardList.do";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String boardReplyView(int bid, Board board, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		return "board/reply";
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String boardReply(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("replyResult", boardService.boardReply(board, request));
		return "forward:boardList.do";
	}
}
