package com.studyboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private String writer;
	private String content;
	@Temporal(value = TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	
}
