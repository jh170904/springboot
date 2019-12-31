package com.studyboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Board;
import com.studyboot.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	//@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목10");
		System.out.println("검색 결과");
		for(Board b : boardList){
			System.out.println("--------> "+b.toString());
		}
	}
	
	//@Test
/*	public void testQueryAnnotationTest2() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest2("테스트 제목10");
		System.out.println("검색 결과");
		for(Object[] row : boardList){
			System.out.println("--------> "+Arrays.toString(row));
		}
	}
*/	
	//@Test
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목10");
		System.out.println("검색 결과");
		for(Object[] row : boardList){
			System.out.println("--------> "+Arrays.toString(row));
		}
	}
	
	//@Test
	public void testQueryAnnotationTest4() {
		Pageable paging  = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
		//첫번째 페이지부터 세개의 데이터씩, 정렬은 seq기준으로 내림차순
		List<Board> boardList = boardRepo.queryAnnotationTest4(paging);
		System.out.println("검색 결과");
		for(Board b : boardList){
			System.out.println("--------> "+b.toString());
		}
	}
}

