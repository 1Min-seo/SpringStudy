package com.care.dbConfig.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.dbConfig.dto.MemberDTO;
import com.care.dbConfig.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired 
	private HttpSession session;
	@Autowired 
	private MemberRepository repository;
	
	public String login(MemberDTO member) {
		
		if(member.getId()== "") {
			return "아이디를 입력하세요";
		}
		if(member.getPw()== "") {
			return "비밀번호를 입력하세요";
		}
		
		MemberDTO check = repository.login(member.getId());
		if(check!=null && check.getPw().equals(member.getPw())) {
			session.setAttribute("id", check.getId());
			session.setAttribute("name", check.getName());
			session.setAttribute("email", check.getName());
			return "로그인 성공";
		}
		
		return "아이디 / 비밀번호를 확인 후 입력하세요.";
	}

	public String register(MemberDTO member) {
		if(member.getId()=="") {
			return "아이디를 입력하세요";
		}
		if(member.getPw()=="") {
			return "비밀번호를 입력하세요";
		}
		MemberDTO check = repository.login(member.getId());
		if(check==null) {
			repository.register(member);
			return "회원 가입 성공";
		}
		return member.getId()+" 계정은 이미 가입된 정보입니다.";
	}
	
}
