package com.studyboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.domain.Member;
import com.studyboot.domain.Role;
import com.studyboot.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class PasswordEncoderTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder; // @Bean으로 등록한 PasswordEncoder 의존성 주입
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setId("manager2");
		member.setPassword(encoder.encode("manager456")); // 입력한 비밀번호를 인코딩하여 저장
		member.setName("매니저2");
		member.setRole(Role.ROLE_MANAGER);
		member.setEnabled(true);
		memberRepo.save(member);
	}
}
