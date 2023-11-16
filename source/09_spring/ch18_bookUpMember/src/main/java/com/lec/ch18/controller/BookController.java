package com.lec.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch18.service.BookService;
import com.lec.ch18.vo.Book;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "detail", method= {RequestMethod.GET, RequestMethod.POST})
	public String bookDetail(Model model, int bnum) {
		model.addAttribute("book", bookService.getDetailBook(bnum));
		return "book/detail";
	}
	@RequestMapping(value = "modify", method=RequestMethod.GET)
	public String bookModify(Model model, int bnum) {
		model.addAttribute("book", bookService.getDetailBook(bnum));
		return "book/modify";
	}
	@RequestMapping(value = "modify", method=RequestMethod.POST)
	public String bookModify(MultipartHttpServletRequest mRequest, Book book, Model model) {
		model.addAttribute("modifyResult", bookService.modifyBook(mRequest, book));
		return "forward:detail.do";
	}
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public String bookList(Model model, String pageNum) {
		model.addAttribute("bookList", bookService.bookList(pageNum));
		return "book/list";
	}
	@RequestMapping(value = "register", method=RequestMethod.GET)
	public String bookRegister() {
		return "book/register";
	}
	@RequestMapping(value = "register", method=RequestMethod.POST)
	public String bookRegister(MultipartHttpServletRequest mRequest, Book book, Model model) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, book));
		return "redirect:register.do";
	}
}
