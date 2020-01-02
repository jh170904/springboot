package com.studyboot.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User{
	private static final long serialVersionUID = 1L;
	public SecurityUser(Member member) {
		//User 클래스의 생성자 호출 시 검색결과로 얻은 member 객체의 값 전달
		super(member.getId(), member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}	
}