package com.care.dbConfig.controller;

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
		if("로그인 성공".equals(msg)) {
			return "index";
		}
		return "login";
	}
}
