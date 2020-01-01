package com.studyboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public void login() {
		//로그인 페이지로 이동시켜주는 메소드
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		//로그인 성공 페이지로 이동시켜주는 메소드
	}
}
