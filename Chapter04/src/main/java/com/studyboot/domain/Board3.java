package com.studyboot.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board3
 * 키 생성 전략 : 자동전략
 */
@Entity
public class Board3 {
	@Id
	@GeneratedValue // 식별자 필드에 @GeneratedValue만 사용하면 기본 값인 AUTO 적용
	private Long seq; 
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
