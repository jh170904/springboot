package com.studyboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.studyboot.controller.BoardController;

@RunWith(SpringRunner.class)
@SpringBootTest(//classes = BoardController.class,
properties = { "author.name=hahaha",
		"author.age=33",
		"author.nation=Korea"
})
public class PropertiesTest {

	@Autowired
	Environment environment;
	
	@Test
	public void testMethod() {
		System.out.println("이름:"+ environment.getProperty("author.name"));
		System.out.println("나이:"+ environment.getProperty("author.age"));
		System.out.println("국적:"+ environment.getProperty("author.nation"));
	}
	
}
