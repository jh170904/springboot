package com.studyboot.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.studyboot.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>
	,QuerydslPredicateExecutor<Board>{
	//글 목록 검색
	@Query("SELECT b FROM Board b")
	public Page<Board> getBoardList(Pageable pageable); // 페이징 처리를 위해 Pageable 매개변수 사용
}
