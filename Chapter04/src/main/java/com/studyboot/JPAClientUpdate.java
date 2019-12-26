package com.studyboot;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.studyboot.domain.Board;
import com.studyboot.domain.Board2;
import com.studyboot.domain.Board3;

public class JPAClientUpdate {
	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();

		//글 수정
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//Transaction 시작
			tx.begin();
			//수정할 엔티티 조회
			Board3 board = em.find(Board3.class, 1L);
			board.setTitle("검색한 게시글의 정보를 수정");
		
			//Transaction commit
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//Transaction rollback
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}	

	}

}
