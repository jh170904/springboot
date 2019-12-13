package com.studyboot.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studyboot.jdbc.util.JDBCConnectionManager;

// @Configuration을 가지고 있으므로 자동으로 빈 등록. 빈 등록시 @Bean설정들도 객체로 등록
@Configuration
// 활성화할 프로퍼티 클래스를 지정할 때 사용 
@EnableConfigurationProperties(JDBCConncetionManagerProperties.class)
public class BoardAutoConfiguration {

	@Autowired // 의존성 주입하여 사용가능
	private JDBCConncetionManagerProperties properties;
	
	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJdbcConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		
		return manager;
	}
}
