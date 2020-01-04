package com.studyboot.service;

import org.springframework.data.domain.Page;

import com.studyboot.domain.Board;
import com.studyboot.domain.Search;

public interface BoardService {
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(Board board);
	public Board getBoard(Board board);
	//public Page<Board> getBoardList(Board board);
	public Page<Board> getBoardList(Search search);
}
