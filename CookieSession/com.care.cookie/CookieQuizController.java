package com.care.cs.cookie;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieQuizController {
	
	/*
	 cookie/cookie 요청 시 cookie.jsp에서 자바스크립트 window.open()으로 팝업창 실행
	 팝업창 내용은 cookie/popup 요청으로 popup.jsp를 실행
	 popup.jsp에서 checkbox를 구성해서 checkbox를 클릭하면 cookie/make 요청으로 쿠키 생성.
	 쿠키 생성 후에는 cookie/cookie 요청 시 cookie.jsp에서 자바스크립트 window.open()으로 팝업창 실행하지 않는다.
	 */
	@RequestMapping("cookie/cookie")
	public void cookie() {}
	@RequestMapping("cookie/popup")
	public void popup() {}
	@RequestMapping("cookie/make")
	public void make() {}
	 
}
