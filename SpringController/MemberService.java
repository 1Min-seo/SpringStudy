package com.care.sc.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.sc.dto.LoginDTO;
import com.care.sc.dto.RegisterDTO;
import com.care.sc.repository.MemberDAO;

@Service
public class MemberService {
	
	// spring에다가 httpsession 자료형의 객체를 생성을 하고 그 참조값은 session에 넣어둠.
	@Autowired private MemberDAO memberDao;
	@Autowired private HttpSession session;
	
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
			session.setAttribute("id", check.getId());
			session.setAttribute("name", check.getName());
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
	
	public ArrayList<RegisterDTO> list() {
		return memberDao.list();
	}

	public String update(RegisterDTO reg) {
		if(reg.getPw()=="" && reg.getName()=="")
			return "데이터를 입력하세요";
		memberDao.update(reg);	
		
		return "회원 수정 성공";
	}

	public String delete(String pw, String confirm) {
		if(pw==null || confirm==null || pw.isEmpty() || confirm.isEmpty()) {
			return "비밀번호를 입력하세요";
		}
		if(pw.equals(confirm)==false) {
			return "입력한 두 비밀번호를 동일하게 입력하세요";
		}
		String id=(String)session.getAttribute("id");
		LoginDTO reg= memberDao.login(id); //다른부분
		if(reg != null && reg.getPw().equals(pw)) {
			memberDao.delete(id);
			return "회원 삭제 성공";
		}
		return "비밀번호가 틀렸습니다.";
	}
}
