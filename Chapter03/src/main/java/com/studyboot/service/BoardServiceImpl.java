package com.studyboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.studyboot.domain.BoardVO;
/* 비즈니스 컴포넌트 모킹 테스트 해보기 */
@Service
public class BoardServiceImpl implements BoardService{
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다............");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i=0; i<10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목" + i);
			board.setWriter("테스터");
			board.setContent(i+"번 내용입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}

}
