package com.studyboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studyboot.domain.Board;
import com.studyboot.service.BoardService;

@Controller
public class BoardController {
 
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardLists(board);//게시글 목록 가져오기
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	@GetMapping("/insertBoard") 
	public String insertBoardView(Board board) {
		return "insertBoard"; //게시글 작성 페이지
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board); 
		return "redirect:getBoardList";//게시글 작성 후 리스트 페이지로 리다이렉트
	}
	
	@GetMapping("/getBoard") 
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard"; //게시글 상세 페이지
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board); 
		return "forward:getBoardList";//게시글 수정 후 포워딩
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board); 
		return "forward:getBoardList";//게시글 삭제 후 포워딩
	}
}
