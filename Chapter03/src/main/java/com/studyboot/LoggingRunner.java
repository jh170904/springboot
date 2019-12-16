package com.studyboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/* 로거 커스터마이징 해보기 */
@Service
public class LoggingRunner implements ApplicationRunner{

	private final static Logger LOGGER = LoggerFactory.getLogger(LoggingRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.trace("TRACE 로그메세지");
		LOGGER.debug("DEBUG 로그메세지");
		LOGGER.info("INFO 로그메세지");
		LOGGER.warn("WARN 로그메세지");
		LOGGER.error("ERROR 로그메세지");
	}

}
