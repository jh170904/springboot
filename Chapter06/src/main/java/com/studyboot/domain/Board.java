package com.studyboot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity //엔티티 클래스
public class Board {
	@Id // 식별자 필드
	@GeneratedValue // 자동으로 시퀀스 증가 
	private Long seq;
	private String title;
	@Column(updatable = false) // update의 경우 제외하는 속성
	private String writer;
	private String content;
	@Column(insertable = false, // insert의 경우 제외하는 속성
			updatable = false, 
			columnDefinition = "date default sysdate") // null이 아니라 default 설정을 추가해서 반영
	private Date createDate;
	@Column(insertable = false, 
			updatable = false, 
			columnDefinition = "number default 0")
	private Long cnt;
}
