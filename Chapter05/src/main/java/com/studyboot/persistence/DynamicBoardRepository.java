package com.studyboot.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.studyboot.domain.Board;
//동적쿼리 사용
public interface DynamicBoardRepository extends CrudRepository<Board, Long>
	, QuerydslPredicateExecutor<Board>{

}
