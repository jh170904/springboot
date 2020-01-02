package com.studyboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //이 클래스로 생성된 객체는 시큐리티 설정 파일을 의미. 동시에 시큐리티에 필요한 객체들을 생성
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//WebSecurityConfigurerAdapter 클래스를 빈으로 설정하기만 해도 애플리케이션은 로그인을 강제하지 않음

	@Autowired
	private BoardUserDetailService boardUserDetailService;
	
	//@Autowired
	//private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override //시큐리티와 관련된 설정시 configure 메소드 사용
	protected void configure(HttpSecurity security) throws Exception {
		
		// 애플리케이션 자원에 대한 인증과 인가 제어 가능.
		// authorizeRequests 사용자 인증과 권한 설정 
		// antMatchers AuthorizedUrl 반환	
		//빌더 패턴을 사용하므로 아래와 같이 작성가능 
		security.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/member/**").authenticated()
					.antMatchers("/manager/**").hasRole("MANAGER")
					.antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable();

		
		security.formLogin(); // 사용자에게 form 태그 기반의 로그인 화면 표시 

		security.formLogin()
					.loginPage("/login") // 로그인시 사용할 화면 별도 지정. 
					.defaultSuccessUrl("/loginSuccess", true); //로그인 성공시 이동할 url 지정
		
		security.exceptionHandling() //ExceptionHandlingConfigurer 객체 리턴
					.accessDeniedPage("/accessDenied"); // 인증되지 않은 사용자에게 제공할 url 지정
		
		security.logout().invalidateHttpSession(true)	// 현재 브라우저와 연관된 세션을 강제종료
					.deleteCookies() 					// 쿠키 삭제 
					.logoutSuccessUrl("/login");		// 로그아웃 후 이동할 화면 리다이렉트
		
		security.userDetailsService(boardUserDetailService);
	}
	
	/*
	// 메모리 사용자 인증하기 테스트 : 인증에 필요한 사용자 정보 생성
	@Autowired //AuthenticationManagerBuilder 객체를 의존성 주입받음
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() // 메모리에 사용자 정보를 생성하는 메소드
			.withUser("manager") // 사용자 아이디
			.password("{noop}manager123") // 비밀번호. {noop}은 암호화 처리를 하지 않음
			.roles("MANAGER"); // 권한 설정
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin123")
		.roles("ADMIN");
	}
	*/
	
	/*
	//데이터베이스에 저장된 회원정보로 인증 처리 테스트
	@Autowired //AuthenticationManagerBuilder 객체를 의존성 주입받음
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		//사용자 정보 조회 쿼리
		String query1 = "select id username, concat('{noop}', password) password, true enabled from member where id = ?";
		//사용자 권한 조회 쿼리
		String query2 = "select id, role from member where id = ?";
		
		auth.jdbcAuthentication()	//데이터베이스에 저장된 사용자로 인증처리 하는 메소드
				.dataSource(dataSource)
				.usersByUsernameQuery(query1)//사용자 정보의 컬럼명이 username과 password 와 일치해야 자동 매핑
				.authoritiesByUsernameQuery(query2);//인증 성공과 접근권한이 있는 사용자의 경우 리소스접근 가능
	}
	*/
}
