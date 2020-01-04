package com.studyboot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studyboot.domain.Member;
import com.studyboot.domain.SecurityUser;
import com.studyboot.persistence.MemberRepository;

@Service
public class SecurityUserDetailService implements UserDetailsService{
	@Autowired
	private MemberRepository memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional = memberRepo.findById(username); //사용자 정보 조회
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username+" 사용자 없음");
		} else {
			Member member = optional.get();
			return new SecurityUser(member); //정보 있을 경우 SecurityUser객체로 리턴 
		}
	}
}
