package com.care.dbConfig.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.dbConfig.dto.MemberDTO;
import com.care.dbConfig.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(MemberDTO member, Model model) {
		String msg=service.login(member);
		model.addAttribute("msg",msg);
		if("로그인 성공".equals(msg)) {
			return "index";
		}
		return "login";
	}
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(MemberDTO member, Model model) {
		String msg=service.register(member);
		model.addAttribute("msg",msg);
		if("회원 가입 성공".equals(msg)) {
			return "index";
		}
		return "register";
	}
	
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("members", service.list());
		
	}
	
	@Autowired HttpSession session;
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "forward:index";
	}
	
	@GetMapping("update")
	public String update() {
		if(session.getAttribute("id")==null)
			return "login";
		return "update";
	}
	@PostMapping("update")
	public String update(MemberDTO member, Model model) {
		String id=(String)session.getAttribute("id");
		if(id==null)
			return "login";
		member.setId(id);
		String msg=service.update(member);
		if(msg.equals("수정 성공")) {
			return "forward:index";
		}
		return "update";
	}
	
	@GetMapping("delete")
	public String delete() {
		if(session.getAttribute("id")==null)
			return "login";
		return "delete";
	}
	@PostMapping("delete")
	public String update(String pw, String confirm, Model model) {
		String id=(String)session.getAttribute("id");
		if(id==null)
			return "login";
		
		String msg=service.delete(pw,confirm);
		model.addAttribute("msg",msg);
		if(msg.equals("수정 성공")) {
			return "redirect:index";
		}
		return "delete";
	}
}
