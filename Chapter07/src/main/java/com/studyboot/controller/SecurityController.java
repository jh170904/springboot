package com.studyboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("index 요청"); // 모든 사용자 가능
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		System.out.println("member 요청"); // 인증 통과한 사용자 가능
		return "member";
	}
	
	@GetMapping("/manager")
	public String manager() {
		System.out.println("manager 요청"); // 인증을 통과한 manager 권한 사용자 가능
		return "manager";
	}
	
	@GetMapping("/admin")
	public String admin() {
		System.out.println("admin 요청"); // 인증을 통과한 admin 권한 사용자 가능
		return "admin";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
}
