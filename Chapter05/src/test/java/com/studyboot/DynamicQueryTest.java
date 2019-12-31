package com.studyboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.studyboot.domain.Board;
import com.studyboot.domain.QBoard;
import com.studyboot.persistence.DynamicBoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;
	
	//@Test
	public void testDynamicQuery() {
		String searchCondition = "CONTENT";
		String searchKeyword = "테스트 제목10";
		
		BooleanBuilder builder = new BooleanBuilder(); //가변적인 파라미터 값에 따라 동적으로 AND나 OR조건 반영 가능
		
		QBoard qBaord = QBoard.board;
		
		//검색 조건에 따른 분기처리
		if (searchCondition.equals("TITLE")) {
			builder.and(qBaord.title.like("%"+searchKeyword+"%"));
		} else if (searchCondition.equals("CONTENT")) {
			builder.and(qBaord.content.like("%"+searchKeyword+"%"));
		}
		
		// 페이징 처리를 위해 pagable 객체 생성 
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
}
