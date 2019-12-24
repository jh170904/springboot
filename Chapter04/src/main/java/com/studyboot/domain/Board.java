package com.studyboot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Table(name = "BOARD")
public class Board implements Serializable {
	
	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String writer; 
	private String content;
	private Date createDate; 
	private Long cnt;
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
