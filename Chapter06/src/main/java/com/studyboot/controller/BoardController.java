package com.studyboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.studyboot.domain.Board;
import com.studyboot.domain.Member;
import com.studyboot.service.BoardService;

@SessionAttributes("member") //로그인 사용자만 게시판 기능을 사용하도록 인증상태 유지를 위해 세션 활용
@Controller
public class BoardController {
 
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting","Hello 타임리프");
	}
	
	@ModelAttribute("member") // 이 어노테이션을 통해 세션에 이 메소드가 반환하는 Member객체가 제일 먼저 세션에 등록된다.
	public Member setMember() {
		return new Member();
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		
		if(member.getId() == null) {
			return "redirect:login";//로그인 아이디가 없을 경우 로그인 페이지로 리다이렉트
		}		
		List<Board> boardList = boardService.getBoardLists(board);//게시글 목록 가져오기
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard") 
	public String insertBoardView(Board board) {
		return "insertBoard"; //게시글 작성 페이지
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";//로그인 아이디가 없을 경우 로그인 페이지로 리다이렉트
		}
		boardService.insertBoard(board); 
		return "redirect:getBoardList";//게시글 작성 후 리스트 페이지로 리다이렉트
	}
	
	@GetMapping("/getBoard") 
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if(member.getId() == null) {
			return "redirect:login";//로그인 아이디가 없을 경우 로그인 페이지로 리다이렉트
		}
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard"; //게시글 상세 페이지
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";//로그인 아이디가 없을 경우 로그인 페이지로 리다이렉트
		}
		boardService.updateBoard(board); 
		return "forward:getBoardList";//게시글 수정 후 포워딩
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";//로그인 아이디가 없을 경우 로그인 페이지로 리다이렉트
		}
		boardService.deleteBoard(board); 
		return "forward:getBoardList";//게시글 삭제 후 포워딩
	}
}
