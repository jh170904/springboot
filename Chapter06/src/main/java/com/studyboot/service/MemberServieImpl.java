package com.studyboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyboot.domain.Member;
import com.studyboot.persistence.MemberRepository;

@Service
public class MemberServieImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getId()); // 특정 회원 검색
		if(findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}
}
