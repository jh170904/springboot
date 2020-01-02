package com.studyboot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "member")//순환 참조를 막기 위함
@Entity
public class Board {//게시판 테이블과 매핑할 변수들을 멤버로 선언
	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String content;
	
	//기본값 가지도록 설정.
	//JPA가 수정 처리할 때 JPA의 구현체인 하이버네이트가 수정 SQL에 해당칼럼을 포함하지 않도록 설정
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();
	@Column(updatable = false)
	private Long cnt = 0L;
	
	//다대일 연관관계 매핑
	@ManyToOne  //양방향 연관관계에서 다(N)에 해당 & 외래키(FK)를 소유한 Board 엔티티가 연관관계의 주인.
	@JoinColumn(name = "MEMBER_ID"  //MEMBER_ID 칼럼을 통해서 외래키를 관리
			,nullable = false //외부조인이 아닌 내부조인으로 처리하기 위해 nullable 속성 사용
			,updatable = false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
