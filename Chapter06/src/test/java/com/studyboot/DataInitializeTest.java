package com.studyboot;

import java.util.Date;

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
public class DataInitializeTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void TestDataInsert() {
		
		Member mem1 = new Member();
		mem1.setId("mem1");
		mem1.setName("hello");
		mem1.setPassword("123");
		mem1.setRole("user");
		memberRepo.save(mem1); //회원정보를 먼저 영속성 컨텍스트에 저장
		
		Member mem2 = new Member();
		mem2.setId("mem2");
		mem2.setName("bye");
		mem2.setPassword("456");
		mem2.setRole("admin");
		memberRepo.save(mem2);
		
		for (int i=1; i<=3; i++) {
			Board b = new Board();
			b.setWriter("hello");
			b.setTitle("hello가 작성한 글" + i);
			b.setContent("내용"+i);
			boardRepo.save(b); //게시글 엔티티 저장
		}
		
		for (int i=1; i<=3; i++) {
			Board b = new Board();
			b.setWriter("bye");
			b.setTitle("bye가 작성한 글" + i);
			b.setContent("내용"+i);
			boardRepo.save(b);
		}
	}

}
