package com.studyboot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString(exclude = "boardList")//상호 호출 연결고리를 끊기 위해 exclude 속성 설정.
@Entity
public class Member {
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	//일대다 관계. 하나의 객체가 여러 객체와 연관관계를 맺을 수 있으므로 List와 같은 컬렉션을 사용해야 함 
	@OneToMany(mappedBy = "member", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
}
