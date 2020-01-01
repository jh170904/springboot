package com.studyboot.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //컨트롤러에서 발생하는 모든 예외를 GlobalExceptionHandler 객체가 처리.
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BoardException.class) // 발생한 예외에 따라 다른 화면을 출력하기 위해서 사용
	public String handleCustomException(BoardException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/boardError";
	}
	
	@ExceptionHandler(Exception.class) // 모든 예외의 최상위 부모인 Exception 타입의 객체를 처리
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}
}
