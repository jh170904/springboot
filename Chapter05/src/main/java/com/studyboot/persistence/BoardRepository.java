package com.studyboot.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.studyboot.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	// 쿼리메소드 구현
	List<Board> findByTitle(String searchKeyword);
	
	// LIKE 연산자
	List<Board> findByContentContaining(String searchKeyword);
	
	// 여러 조건 사용
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// 데이터 정렬
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	// 페이징 처리 
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	// 페이징 처리
	Page<Board> findBoardByTitleContaining(String searchKeyword, Pageable paging);

	// 위치 기반 파라미터 사용
	//@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	//List<Board> queryAnnotationTest1(String searchKeyword);
	
	// 이름 기반 파라미터 사용
	@Query("SELECT b FROM Board b WHERE b.title LIKE %:searchKeyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	// 특정변수만 조회하기
	//@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	//List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	// 네이티브 쿼리 (엔티티 기준이 아니라 컬럼명 기준이므로 주의하자)
	@Query(value="SELECT seq, title, writer, create_date FROM Board WHERE title LIKE '%'||?1||'%' ORDER BY seq DESC"
			,nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);	
	
	// 페이징 및 정렬 사용
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest4(Pageable paging);
	
}
