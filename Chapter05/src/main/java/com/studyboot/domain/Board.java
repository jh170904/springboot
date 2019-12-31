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
@ToString(exclude = "member") //상호 호출 연결고리를 끊기 위해 exclude 속성 설정. 
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
	@JoinColumn(name="MEMBER_ID", nullable = false) //참조하는 외래키 칼럼과 매핑 관계를 설정하는 어노테이션
	private Member member;
	
	//영속상태가 아닌 단순한 일반 자바 객체 상태에서도 관련된 데이터를 사용하기 위함
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
