package com.studyboot.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 * 키 생성 전략 : 테이블 전략
 */
@Entity
@TableGenerator(name = "BOARD_SEQ_GENERATOR",
		table = "ALL_SEQUENCES", 				//ALL_SEQUENCES 라는 키 생성 테이블을 만듦
		pkColumnValue = "BOARD_SEQ",			//BOARD_SEQ 이름으로 증가되는 값을 저장
		initialValue = 0,						//처음 저장되는 번호는 0
		allocationSize = 1)						//ALL_SEQUENCES 테이블에서 값을 한 번 꺼내 쓸 때마다 자동으로 1씩 증가
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	private Long seq; // 식별자 생성 전략을 GenerationType.TABLE 로 지정, BOARD_SEQ_GENERATOR 키 생성기 참조
	private String title;
	private String writer; 
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate; 
	private Long cnt;
	
	@Transient //영속 필드에 제외시 사용
	private String searchConfition;
	@Transient
	private String searchKeyword;
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	public String getSearchConfition() {
		return searchConfition;
	}
	public void setSearchConfition(String searchConfition) {
		this.searchConfition = searchConfition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Board [");
		sb.append("seq=").append(seq)
			.append(", title=").append(title)
			.append(", writer=").append(writer)
			.append(", content=").append(content)
			.append(", createDate=").append(createDate)
			.append(", cnt=").append(cnt)
			.append("]");
		return sb.toString();
	}
   
}
