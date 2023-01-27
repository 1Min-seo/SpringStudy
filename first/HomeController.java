package com.care.first;

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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		//모델을 통한 데이터 등록.
		model.addAttribute("serverTime", formattedDate);
		
		//model.addAttribute("id", "admin" );
		model.addAttribute("pw",1234);
		
		//뷰 페이지를 home.jsp로 설정
		return "home";
		
		//serverTime 데이터를 등록한다. 그리고 리턴 값을 통해 home.jsp를 반환한다.
		//여기서 반환 값을 기준으로 View페이지를 설정하게 된다.
	}
	
}
