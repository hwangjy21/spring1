package com.ezen.myProject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.myProject.domain.MemberVO;
import com.ezen.myProject.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/*")
@Controller
public class MemberController {

	@Inject
	private MemberService msv;
	
	@GetMapping("/signup")
	public String signupGet() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVO mvo) {
		log.info(">>>> 회원가입 객체>> "+ mvo);
		int isOk= msv.signup(mvo);
		log.info(">>>> signUp? >>"+(isOk>0? "OK":"FAIL"));
		return "index";
	}
	
	@GetMapping("/login")
	public String loginGet() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(MemberVO mvo, HttpServletRequest request, Model m) {
		log.info(">>>> 로그인 사용자 >> "+mvo);
		//mvo 객체를 db에서 일치하는지 체크
		MemberVO loginmvo = msv.isUser(mvo);
		
		//DB에서 가져온 loginmvo가 null이 아니라면 세션에 저장
		if(loginmvo != null) {
			HttpSession ses = request.getSession();
			ses.setAttribute("ses", loginmvo); //세션에 로그인 객체 저장
			ses.setMaxInactiveInterval(60*10); //로그인 유지 시간
		}else {
			m.addAttribute("msg_login", 1);
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model m) {
		request.getSession().removeAttribute("ses"); //세션 객체 삭제
		request.getSession().invalidate(); //세션 끊기
		m.addAttribute("msg_logout", 1);
		return "index";
	}
	
	@GetMapping("/modify")
	public String modifyGet() {
		return "/member/modify";
	}
	
	@PostMapping("/modify")
	public String modifyPost(MemberVO mvo, RedirectAttributes re) {
		log.info(">>>>> modify mvo >> "+mvo);
		int isOk = msv.modify(mvo);
		log.info(">>>> modify ? >>"+(isOk>0? "OK":"FAIL"));
		re.addFlashAttribute("msg_modify", 2);
		return "redirect:/member/logout";
	}
	
	
}
