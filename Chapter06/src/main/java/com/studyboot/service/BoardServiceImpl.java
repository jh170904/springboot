package com.studyboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyboot.domain.Board;
import com.studyboot.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	/**
	 * <pre>
	 * getBoardLists
	 * 게시글 리스트 조회
	 * </pre>
	 * */
	public List<Board> getBoardLists(Board board){
		return (List<Board>) boardRepo.findAll(); //Board 테이블의 모든 객체를 가져와 리턴하는데 형변환시켜줌
	}
	/**
	 * <pre>
	 * insertBoard
	 * 게시글 입력
	 * </pre>
	 * */	
	public void insertBoard(Board board) {
		boardRepo.save(board);//영속화
	}
	/**
	 * <pre>
	 * getBoard
	 * 게시글 상세 조회
	 * </pre>
	 * */
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	/**
	 * <pre>
	 * updateBoard
	 * 게시글 수정
	 * </pre>
	 * */
	public void updateBoard(Board board) {
		Board beforeBoard = boardRepo.findById(board.getSeq()).get();
		beforeBoard.setTitle(board.getTitle());
		beforeBoard.setContent(board.getContent());
		boardRepo.save(beforeBoard);//UPDATE구문을 SQL저장소로 등록
	}
	
	/**
	 * <pre>
	 * deleteBoard
	 * 게시글 삭제
	 * </pre>
	 * */
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}
}
