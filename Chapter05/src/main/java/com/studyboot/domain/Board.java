package com.studyboot.domain;

import java.util.Date;

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
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long seq;		//식별자 변수 매핑
	private String title;
//	private String writer; //Member 클래스를 통해 회원정보 관리
	private String content;
	@Temporal(value = TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	
	@ManyToOne //다대일 관계설정
	@JoinColumn(name="MEMBER_ID") //참조하는 외래키 칼럼과 매핑 관계를 설정하는 어노테이션
	private Member member;
}
