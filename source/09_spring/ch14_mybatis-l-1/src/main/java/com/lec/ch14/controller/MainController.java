package com.lec.ch14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch14.service.EmpService;
import com.lec.ch14.vo.Dept;
import com.lec.ch14.vo.Emp;

@Controller
public class MainController {
	@Autowired
	private EmpService empService;
	
	@ModelAttribute("deptList")
	public List<Dept> deptList() {
		return empService.deptList();
	}

	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(@ModelAttribute("searchEmp") Emp searchEmp, Model model) {
		model.addAttribute("empList", empService.empList(searchEmp));
		return "emp";
	}
}
