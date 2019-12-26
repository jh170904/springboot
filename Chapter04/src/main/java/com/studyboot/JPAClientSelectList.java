package com.studyboot;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.studyboot.domain.Board;
import com.studyboot.domain.Board2;
import com.studyboot.domain.Board3;

public class JPAClientSelectList {
	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//Transaction 시작
			tx.begin();
			Board3 board = new Board3();
			board.setTitle("어깨아파");
			board.setWriter("관리자");
			board.setContent("스트레칭을 해주자");
			board.setCreateDate(new Date());
			board.setCnt(0L);
		
			//글 등록
			em.persist(board);
			
			//Transaction commit
			tx.commit();
			
			//글 목록조회
			String jpql = "select b from Board3 b order by b.seq desc";
			List<Board3> boardList = em.createQuery(jpql,Board3.class).getResultList();
			for (Board3 brd : boardList) {
				System.out.println(">>> " + brd.toString());
			}
			
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
