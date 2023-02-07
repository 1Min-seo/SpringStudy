package com.care.cs.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionController {
	@RequestMapping("session/index")
	public void index() {}
	
	@GetMapping("session/login")
	public void login() {}
	
	@Autowired private HttpSession session;
	
	@PostMapping("session/login")
	public String login(String id, String pw, RedirectAttributes ra) {
		if("admin".equals(id) && "1234".equals(pw)) {
			ra.addFlashAttribute("msg","로그인 성공");
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			return "redirect:index";
		}
		ra.addFlashAttribute("msg","로그인 실패");
		return "redirect:login";
	}
	
	@RequestMapping("session/logout")
	public String logout(Model model, HttpServletRequest request) {
		session.invalidate(); //세션의 값을 통채로 삭제
		model.addAttribute("msg","로그 아웃");
		String context=request.getContextPath(); // -> /cs/
		model.addAttribute("redirectPath",context+"session/index"); //alert창 띄우기 위해서
		return "session/logout";
	}
}
