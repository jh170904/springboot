package com.studyboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.studyboot.domain.Member;
import com.studyboot.service.MemberService;

@SessionAttributes("member") // 세션에 상태정보를 저장할 때 사용
@Controller
public class LoginController {

	@Autowired
	private MemberService memberService; 
	
	@GetMapping("/login")
	public void loginView() {
		
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		
		// 로그인 시도 회원정보 일치에 따라 분기처리
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "forward:getBoardList"; // 리스트 페이지 포워딩
		} else {
			return "redirect:login"; // 로그인 페이지 리다이렉트
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
}
