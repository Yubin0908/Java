package com.lec.ch12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch12.service.FileUpService;

@Controller
public class MainController {
	@Autowired
	private FileUpService fileUpService; 
	
	@RequestMapping(value="fileUp", method=RequestMethod.GET)
	public String fileUp() {
		return "file_input";
	}
	@RequestMapping(value="fileUp", method=RequestMethod.POST)
	public ModelAndView fileUp(MultipartHttpServletRequest mrs, ModelAndView mov) {
		if(fileUpService.fileUp(mrs, mov)) {
			mov.addObject("fileUpResult", "File Upload Complete");
		} else {
			mov.addObject("fileUpResult", "File Upload Fail");
		}
		mov.setViewName("result");
		return mov;
	}
}
