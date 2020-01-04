package com.studyboot;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Board;
import com.studyboot.domain.Member;
import com.studyboot.domain.Role;
import com.studyboot.persistence.BoardRepository;
import com.studyboot.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test //입력테스트
	public void testInsert() {
		
		Member mem1 = new Member();
		mem1.setId("mem1");
		mem1.setName("hello");
		mem1.setPassword(encoder.encode("123"));
		mem1.setRole(Role.ROLE_MEMBER);
		memberRepo.save(mem1); //회원정보를 먼저 영속성 컨텍스트에 저장
		
		Member mem2 = new Member();
		mem2.setId("mem2");
		mem2.setName("bye");
		mem2.setPassword(encoder.encode("456"));
		mem2.setRole(Role.ROLE_ADMIN);
		memberRepo.save(mem2);
		
		for (int i=1; i<=13; i++) {
			Board b = new Board();
			b.setMember(mem1);
			b.setTitle("hello가 작성한 글" + i);
			b.setContent("내용"+i);
			boardRepo.save(b); //게시글 엔티티 저장
		}
		
		for (int i=1; i<=3; i++) {
			Board b = new Board();
			b.setMember(mem2);
			b.setTitle("bye가 작성한 글" + i);
			b.setContent("내용"+i);
			boardRepo.save(b);
		}
	}
	
//	@Test //상세 조회 테스트
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("[ "+board.getSeq() + "번 게시글 ]");
		System.out.println("제목\t :"+ board.getTitle());
		System.out.println("작성자\t :"+ board.getMember().getName());
		System.out.println("내용\t :" + board.getContent());
		System.out.println("등록일\t :"+ board.getCreateDate());
		System.out.println("조회수\t :"+ board.getCnt());
	}
	
//	@Test //목록 조회 테스트
	public void testGetBoardList() {
		Member member = memberRepo.findById("mem1").get();

		System.out.println("[ "+member.getName() + "의 게시글 ]");
		for(Board b : member.getBoardList()){
			System.out.println(">>>>>" + b.toString());
		}
	}
}
