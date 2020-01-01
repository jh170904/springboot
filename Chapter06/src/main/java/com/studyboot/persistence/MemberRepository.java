package com.studyboot.persistence;

import org.springframework.data.repository.CrudRepository;

import com.studyboot.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

}