package com.studyboot.exception;

//실행시에 발생할 수 있는 모든 예외의 최상위 부모로 사용하기 위해 상속하여 반영
public class BoardException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BoardException(String message) {
		super(message);
	}
}
