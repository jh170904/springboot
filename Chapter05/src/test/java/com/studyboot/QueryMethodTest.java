package com.studyboot;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Board;
import com.studyboot.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	//테스트 메소드가 실행되기 전에 동작하여 테스트에서 사용할 데이터를 세팅
	@BeforeEach
	public void dataPrepare() {
		for(int i=1; i<=200; i++) {
			Board b = new Board();
			
			b.setTitle("테스트 제목"+i);
			b.setWriter("테스터");
			b.setContent("테스트 내용"+i);
			b.setCreateDate(new Date());
			b.setCnt(0L);
			
			boardRepo.save(b);
		}
	}
	
	//@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목10");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
	
	//@Test // LIKE 연산자
	public void testFindByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
	
	//@Test // 여러 조건
	public void	testFindByTitleContainigOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17","17");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
	
	//@Test // 데이터 정렬
	public void testFindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
	
	// 페이징 처리
	//@Test
	public void testFindByTitleContaining() {
		// 페이지 번호 0 부터 조회. 검색할 데이터 개수 5개씩 조회
		//Pageable paging = PageRequest.of(0, 5);

		// 페이징 처리시 정렬을 해야한다면 Sort클래스 사용. 
		// 첫번째 매개변수는 정렬 방향에 대한 정보. 두번째 매개변수는 정렬 대상이 되는 변수명
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		List<Board> boardList = boardRepo.findByTitleContaining("제목",paging);
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
	
	// 페이징 처리
	@Test
	public void testFindBoardByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		Page<Board> pageInfo = boardRepo.findBoardByTitleContaining("제목",paging);
		
		// 페이징 처리와 관련해서 추가로 얻을 수 있는 정보
		System.out.println("PAGE SIZE"+ pageInfo.getSize());
		System.out.println("TOTAL PAGES" + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT" + pageInfo.getTotalElements());
		System.out.println("NEXT" + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();

		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("------>" + board.toString());
		}
	}
}
