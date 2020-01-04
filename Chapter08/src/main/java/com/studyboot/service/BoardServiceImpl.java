package com.studyboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.studyboot.domain.Board;
import com.studyboot.domain.QBoard;
import com.studyboot.domain.Search;
import com.studyboot.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepo;
	
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}

	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}

	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}

//	public Page<Board> getBoardList(Board board) {
//		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
//		return boardRepo.getBoardList(pageable);
//	}
		
	public Page<Board> getBoardList(Search search) {
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qBoard = QBoard.board;
		if(search.getSearchCondition().equalsIgnoreCase("TITLE")) {
			builder.and(qBoard.title.like("%"+search.getSearchKeyword()+"%"));
		} else if(search.getSearchCondition().equalsIgnoreCase("CONTENT")) {
			builder.and(qBoard.content.like("%"+search.getSearchKeyword()+"%"));
		}
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		return boardRepo.findAll(builder, pageable);
	}
}
