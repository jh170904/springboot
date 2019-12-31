package com.studyboot;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Board;
import com.studyboot.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	/* 등록 기능 테스트 */
	//@Test
	public void testInserBoard() {
		Board b = new Board();
		b.setTitle("첫번째 게시물");
		//b.setWriter("테스터");
		b.setContent("잘 등록되는가?");
		b.setCreateDate(new Date());
		b.setCnt(0L);
		
		// JPA persist 메소드와 동일한 역할
		boardRepo.save(b);
	}

	/* 상세 조회 기능 테스트 */
	//@Test
	public void testGetBoard() {
		Board b = boardRepo.findById(1L).get(); 
		//데이터 하나 조회. 
		//Optional 타입의 객체를 get메소드를 이용해서 영속성 컨텍스트에 저장된 Board 객체로 받아냄
		System.out.println(b.toString());
	}
	
	/* 수정 기능 테스트 */
	//@Test
	public void testUpdateBoard() {
		System.out.println("===== 1번 게시글 조회 =====");
		Board b = boardRepo.findById(1L).get(); // 영속성 컨텍스트에 올리기 위해 조회

		System.out.println("===== 1번 게시글 제목 수정 =====");
		b.setTitle("수정한 제목 입니당"); // 수정할 값 설정
		boardRepo.save(b);// 수정 작업 반영
	}
	
	/* 삭제 기능 테스트 */
	//@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
}
