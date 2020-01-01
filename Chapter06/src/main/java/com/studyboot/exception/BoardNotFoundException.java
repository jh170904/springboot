package com.studyboot.exception;
//Board 엔티티가 없을 경우 발생하는 예외 클래스
public class BoardNotFoundException extends BoardException{

	private static final long serialVersionUID = 1L;
	
	public BoardNotFoundException(String message) {
		super(message);
	}

}
