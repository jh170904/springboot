package com.studyboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studyboot.jdbc.util.JDBCConnectionManager;

//@Configuration
public class BoardConfiguration {
	
	// 자동설정한 내용이 아닌 프로젝트내에서 DB설정을 특정값으로 변경하고 싶을 경우 
	//@Bean
	public JDBCConnectionManager getJDBConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("org.h2.Driver");
		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
		manager.setUsername("h2");
		manager.setPassword("h2");
		return manager;
	}
}
