package com.studyboot.service;

import java.util.List;

import com.studyboot.domain.BoardVO;

public interface BoardService {
	
	String hello(String name);
	
	BoardVO getBoard();
	
	List<BoardVO> getBoardList();
}
