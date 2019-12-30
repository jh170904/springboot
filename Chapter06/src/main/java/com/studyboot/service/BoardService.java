package com.studyboot.service;

import java.util.List;

import com.studyboot.domain.Board;

public interface BoardService {

	/**
	 * <pre>
	 * getBoardLists
	 * 게시글 리스트 조회
	 * </pre>
	 * */
	List<Board> getBoardLists(Board board);

	/**
	 * <pre>
	 * insertBoard
	 * 게시글 입력
	 * </pre>
	 * */
	void insertBoard(Board board);

	/**
	 * <pre>
	 * getBoard
	 * 게시글 상세 조회
	 * </pre>
	 * */
	Board getBoard(Board board);

	/**
	 * <pre>
	 * updateBoard
	 * 게시글 수정
	 * </pre>
	 * */
	void updateBoard(Board board);

	/**
	 * <pre>
	 * deleteBoard
	 * 게시글 삭제
	 * </pre>
	 * */
	void deleteBoard(Board board);

}