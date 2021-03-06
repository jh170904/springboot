package com.studyboot;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.studyboot.domain.Board;
import com.studyboot.domain.Board2;
import com.studyboot.domain.Board3;

public class JPAClient {
	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
/*			
		try {
			//글 상세 조회
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println(">>>>>> " + searchBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}	
*/
		//글 등록
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//Transaction 시작
			tx.begin();
			Board3 board = new Board3();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록을 해보자");
			board.setCreateDate(new Date());
			board.setCnt(0L);
		
			//글 등록
			em.persist(board);
			
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
