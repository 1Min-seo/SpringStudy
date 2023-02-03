package com.care.sc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.sc.dto.LoginDTO;
import com.care.sc.dto.RegisterDTO;
import com.care.sc.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO memberDao;
	
	public String login(LoginDTO login) {
		System.out.println("아이디: "+login.getId());
		System.out.println("비밀번호: "+login.getPw());
		
		if(login.getId()== "") {
			return "아이디를 입력하세요";
		}
		if(login.getPw()== "") {
			return "비밀번호를 입력하세요";
		}
		
		LoginDTO check = memberDao.login(login.getId());
		
		if(check!=null && check.getPw().equals(login.getPw())) {
			return "로그인 성공";
		}
		
		return "아이디 / 비밀번호를 확인 후 입력하세요.";
	}
	
	//MemberService
	public String register(RegisterDTO reg) {
		if(reg.getId()=="") {
			return "아이디를 입력하세요";
		}
		if(reg.getPw()=="") {
			return "비밀번호를 입력하세요";
		}
		
		LoginDTO check=memberDao.login(reg.getId());
		if(check==null) {
			int rowCount = memberDao.register(reg);
			return "회원 가입 성공";
		}
		return reg.getId()+" 계정은 이미 가입된 정보입니다.";
	}
}
