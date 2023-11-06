package com.lec.ch06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String greetting = "안뇽하세요, 스프링!!";
		
		// request.setAttribute("greetting", greetting); => view 에서는 ${greeting)
		model.addAttribute("greetting", greetting); // view 에서는 ${greeting}
//		System.out.println(greetting); // 콘솔에 뿌리는 방법 1
		logger.info(greetting); // 콘솔에 뿌리는 방법 2(실무에서 쓰는 방법)
//		logger.warn(greetting);
//		logger.error(greetting);
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		System.out.println(formattedDate);
//		logger.info(formattedDate);
//		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // view 파일 명
	}
	
}
