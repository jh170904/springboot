package com.studyboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	
	@Test //다대일 연관관계 등록 테스트
	public void testManyToOneInsert() {
		
		//회원정보를 먼저 영속성 컨텍스트에 저장
		Member mem1 = new Member();
		mem1.setId("mem1");
		mem1.setName("hello");
		mem1.setPassword("123");
		mem1.setRole("user");
		
		Member mem2 = new Member();
		mem2.setId("mem2");
		mem2.setName("bye");
		mem2.setPassword("456");
		mem2.setRole("admin");
	}
}
