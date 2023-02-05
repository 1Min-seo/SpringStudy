package com.care.sc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.sc.dto.LoginDTO;
import com.care.sc.dto.RegisterDTO;
import com.care.sc.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("index")
	public String index() {
		//디비 조회 후
		//model 속성에 데이터 담아 JSP에 가서 출력
		return "index";
	}
	
//	@PostMapping("login")
//	public void login(String id, String pw) {
//		//요청할 때의 파라미터의 이름과 메서드의 파라미터의 이름이 정확히 일치해야 함
//		System.out.println("아이디: "+id);
//		System.out.println("비밀번호: "+pw);
//		
//	}
	
//	@PostMapping("login")
//	public void login(String id,
//			@RequestParam("pw") String pass) { //원래 이름인 pw를 오른 쪽 문자열 변수(pass)에 넣어줌
//		System.out.println("아이디 : "+id);
//		System.out.println("비밀번호 : "+pass);
//	}
	
//	@PostMapping("login")
//	public void login(HttpServletRequest request) {
//		System.out.println("아이디: "+request.getParameter("id"));
//		System.out.println("비밀번호: "+request.getParameter("pw"));
//	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(LoginDTO login, Model model) {
		String msg=service.login(login);
		model.addAttribute("msg",msg);
		if("로그인 성공".equals(msg)) {
			//return "index";
			//return "forwaord:index";
			return "redirect:index";
			/*
			 * return "index";
			 * viewReslover에게 "index" 문자열이 전달되어서
			 * /WEB-INF/views/index.jsp 경로를 완성 후 찾아가서 실행하여
			 * 클라이언트 (웹브라우저)에게 전달함.
			 * 
			 * return "forward:index";
			 * @GetMapping("index") 찾아가서 메서드 실행
			 * 트래픽을 줄일 수 있음
			 * 
			 * return "redirect:index";
			 * 웹브라우저에게 index 라는 경로를 제공하고,
			 * 웹브라우저가 @GetMapping("index") 찾아가서 메서드 실행
			 * url을 맞춤
			 * 
			 */
		}
		return "login";
	}
	
	@GetMapping("register") //jsp를 받아서 실행
	public String register() {
		return "register";
	}
	
	@PostMapping("register")
	public String register(RegisterDTO reg,Model model) {
		//Model은 addAttribute()와 같은 기능을 통해 모델에 원하는
		//속성과 그것에 대한 값을 주어 전달할 뷰에 데이터를 전달한다.
		String msg=service.register(reg);
		model.addAttribute("msg", msg);
		if("회원 가입 성공".equals(msg))
			return "index";
		return "register";
		//회원 가입 성공은 index
		//회원 가입 실패는 register
		
//		System.out.println("아이디: "+register.getId());
//		System.out.println("비밀번호: "+register.getPw());
//		System.out.println("이름: "+register.getName());
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("members",service.list());
		service.list();
		return "list";
	}
	
	@Autowired HttpSession session;
	
	@GetMapping("update")
	public String update() {
		String id=(String)session.getAttribute("id");//object로 반환
		if(id==null) {
			return "login";
		} 
		return "update";
	}
	
	@PostMapping("update")
	public String update(RegisterDTO reg, Model model) {
		String id=(String)session.getAttribute("id");
		if(id==null)
			return "login";
		
		reg.setId(id);
		String msg=service.update(reg);
		model.addAttribute("msg",msg);
		if("회원 수정 성공".equals(msg)) {
			session.setAttribute("name", reg.getName());
			
			return "index";
		}
		return "update";
		
	}
	
	@GetMapping("delete")
	public String delete() {
		String id=(String)session.getAttribute("id");
		if(id==null)
			return "login";
		
		return "delete";
	}
	
	@PostMapping("delete")
	public String delete(String pw, String confirm, Model model) {
		String id=(String)session.getAttribute("id");
		if(id==null)
			return "login";
		
		String msg=service.delete(pw,confirm);
		model.addAttribute("msg", msg);
		if("회원 삭제 성공".equals(msg)) {
			return "forward:logout";
		}
		return "delete";
		
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "redirect:index";
	}
	//index 요청 시 요청 메서드가 get 또는 post 모두 index() 호출 
//	@RequestMapping(value="index")
//	public void index() {}
//
//	//index 요청 시 요청 메서드가 get이면 index() 호출
//	@RequestMapping(value="index", method=RequestMethod.GET)
//	public void requestGetIndex() {};
//	
//	//index 요청시 요청 메서드가 post이면  index() 호출
//	@RequestMapping(value="index", method=RequestMethod.POST)
//	public void requestPostIndex() {}
//	
//	@GetMapping ("index")
//	public void getIndex() {}
//	
//	@PostMapping("index")
//	public void postIndex() {}
}


