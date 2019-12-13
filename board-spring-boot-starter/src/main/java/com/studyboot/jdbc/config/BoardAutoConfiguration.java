package com.studyboot.jdbc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studyboot.jdbc.util.JDBCConnectionManager;

// @Configuration을 가지고 있으므로 자동으로 빈 등록. 빈 등록시 @Bean설정들도 객체로 등록
@Configuration
public class BoardAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJdbcConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
		manager.setUrl("jdbc::oracle:thin:@localhost:1521:xe");
		manager.setUsername("window");
		manager.setPassword("window");
		
		return manager;
	}
}
