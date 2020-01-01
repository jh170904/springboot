package com.studyboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studyboot.persistence.MemberRepository;

@Service
public class BoardUserDetailService implements UserDetailsService {
	@Autowired 
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// MemberRepository 로 회원정보 조회하여 UserDetails 타입으로 반환
		return null;
	}
	
}
