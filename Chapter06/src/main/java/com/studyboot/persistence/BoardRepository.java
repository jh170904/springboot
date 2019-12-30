package com.studyboot.persistence;

import org.springframework.data.repository.CrudRepository;

import com.studyboot.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	//단순 CRUD 만 구현할 것이므로 CrudRepository 인터페이스만 상속
}
