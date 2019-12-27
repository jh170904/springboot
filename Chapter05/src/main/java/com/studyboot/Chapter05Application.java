package com.studyboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter05Application {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(Chapter05Application.class);
		// 웹 어플리케이션이 아닌 일반 자바 어플리케이션으로 실행
		// WebApplicationType.NONE 으로 설정했으므로 내장 톰캣을 구동하지 않고 실행
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

}
