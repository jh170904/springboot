package com.studyboot.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User{

	private static final long serialVersionUID = 1L;
	private Member member;//회원 객체를 멤버 변수인 member에 할당. 인증된 회원정보를 html에서 사용하기 위함
	
	public SecurityUser(Member member) {
		//JPA에서 검색한 회원정보로 부모 클래스의 변수들을 초기화 
		super(member.getId(), member.getPassword(), //암호화 진행안하려면 {"noop"}+member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
}
