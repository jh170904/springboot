package com.studyboot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING) //권한 정보를 문자열로 저장
	private Role role;
	private boolean enabled; // 사용자 사용여부 제어하는 변수
	
	//일대다 관계 매핑. Member가 일에 해당하므로 컬렉션 타입으로 해당하는 객체를 가지고 있어야 함.
	@OneToMany(mappedBy = "member",	 // member가 연관관계의 주인이 아님을 표시
			fetch = FetchType.EAGER) // 즉시 로딩
	private List<Board> boardList = new ArrayList<Board>();
}
