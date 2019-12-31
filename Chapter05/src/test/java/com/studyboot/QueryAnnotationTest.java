package com.studyboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Board;
import com.studyboot.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목10");
		System.out.println("검색 결과");
		for(Board b : boardList){
			System.out.println("--------> "+b.toString());
		}
	}
}

