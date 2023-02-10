package com.care.dbConfig.service;

import java.util.ArrayList;

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
			session.setAttribute("email", check.getEmail());
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

	public ArrayList<MemberDTO> list() {
		return repository.list();
	}

	public String update(MemberDTO member) {
		if(member.getPw()==null || member.getPw().isEmpty()) {
			return "수정할 정보를 입력하세요";
		} 
		if(member.getName()==null || member.getName().isEmpty()) {
			return "수정할 정보를 입력하세요";
		}
		if(member.getEmail()==null || member.getEmail().isEmpty()) {
			return "수정할 정보를 입력하세요";
		}
		
		MemberDTO check=repository.login(member.getId());
		int empty=0;
		if(check.getPw().equals(member.getPw())) {
			member.setPw("");
			empty++;
		}
		if(check.getName().equals(member.getName())) {
			member.setName("");
			empty++;
		}
		if(check.getEmail().equals(member.getEmail())) {
			member.setEmail("");
			empty++;
		}
		if(empty==3)
			return "변동 사항이 없기에 수정할 수 없습니다.";
		
		if(member.getName().isEmpty()==false)
			session.setAttribute("name", member.getName());
		if(member.getEmail().isEmpty()==false)
			session.setAttribute("email", member.getEmail());
		
		repository.update(member);
		return "수정 성공";
	}

	public String delete(String pw, String confirm) {
		if(pw == null || pw.isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		if(confirm == null || confirm.isEmpty()) {
			return "비밀번호를 입력하세요.";
		}
		if(pw.equals(confirm)==false) {
			return "비밀번호를 확인하세요.";
		}
		
		String id=(String)session.getAttribute("id");
		MemberDTO check=repository.login(id);
		if(check != null && check.getPw().equals(pw)) {
			repository.delete(id);
			session.invalidate();
			return "삭제 성공";
		}
		return "비밀번호를 확인하세요.";
	}
	
}
