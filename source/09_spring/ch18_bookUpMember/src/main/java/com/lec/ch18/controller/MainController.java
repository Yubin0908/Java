package com.lec.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch18.service.BookService;

@Controller
@RequestMapping("main")
public class MainController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="main", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model) {
		model.addAttribute("mainList", bookService.mainList());
		return "main/main";
	}
	
}
