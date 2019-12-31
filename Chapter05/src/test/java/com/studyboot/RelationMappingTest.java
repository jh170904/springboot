package com.studyboot;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Board;
import com.studyboot.domain.Member;
import com.studyboot.persistence.BoardRepository;
import com.studyboot.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;
	
	//@Test //다대일 연관관계 등록 테스트
	public void testManyToOneInsert() {
		
		Member mem1 = new Member();
		mem1.setId("mem1");
		mem1.setName("hello");
		mem1.setPassword("123");
		mem1.setRole("user");
//		memberRepo.save(mem1); //회원정보를 먼저 영속성 컨텍스트에 저장
		
		Member mem2 = new Member();
		mem2.setId("mem2");
		mem2.setName("bye");
		mem2.setPassword("456");
		mem2.setRole("admin");
//		memberRepo.save(mem2);
		
		for (int i=1; i<=3; i++) {
			Board b = new Board();
			b.setMember(mem1);
			b.setTitle("hello가 작성한 글" + i);
			b.setContent("내용"+i);
			b.setCreateDate(new Date());
			b.setCnt(0L);
//			boardRepo.save(b); //게시글 엔티티 저장
		}
		memberRepo.save(mem1);// member 객체가 영속화되면서 자동으로 board 객체도 자동으로 영속화된다.
		for (int i=1; i<=3; i++) {
			Board b = new Board();
			b.setMember(mem2);
			b.setTitle("bye가 작성한 글" + i);
			b.setContent("내용"+i);
			b.setCreateDate(new Date());
			b.setCnt(0L);
//			boardRepo.save(b);
		}
		memberRepo.save(mem2);
	}
	
	//@Test //게시글 상세 조회 테스트
	public void testManyToOneSelect() {
		Board b = boardRepo.findById(5L).get();
		System.out.println("["+b.getSeq()+"번 게시글 정보]");
		System.out.println("제목: " + b.getTitle());
		System.out.println("내용: " + b.getContent());
		System.out.println("작성자: " + b.getMember().getName());
		System.out.println("권한: " + b.getMember().getName());
	}
	
	//@Test 	//양방향 연관관계 테스트
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("mem1").get();
		
		System.out.println("-------------------------------------------");
		System.out.println(member.getName() +"의 작성 게시글");
		System.out.println("-------------------------------------------");
		List<Board> list = member.getBoardList();
		for (Board b : list) {
			System.out.println(b.toString());
		}
	}
	
	@Test // 영속성 전이를 이용한 삭제 처리
	public void testCascadeDelete() {
		memberRepo.deleteById("mem2");
	}
}
