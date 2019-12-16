package com.studyboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import com.studyboot.domain.BoardVO;

@RunWith(SpringRunner.class)
//@WebMvcTest
//@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
//@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
public class BoardControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	// WebEnvironment.RANDOM_PORT로 사용할 경우 서블릿 컨테이너를 모킹하지 않기 때문에 MockMvc 객체를 목업할 수 없다.
	// MockMvc 대신 컨트롤러를 실행해줄 TestRestTemplate 객체를 주입

/*
 	@Autowired
	private MockMvc mockMvc; 
	 
	@Test
	public void testHello() throws Exception{
		mockMvc.perform(get("/hello").param("name","hoho")) 
				.andExpect(status().isOk())								
				.andExpect(content().string("Hello : hoho"))
				.andDo(print());
		// perform() 메소드를 이용하여 요청 전송 가능. 결과로 ResultAction 객체를 반환. 
		// ResultAction.andExpect() 는 응답결과를 검증할 수있는 메소드
		// param()은 key,value 형태로 파라미터를 여러개 보낼 수 있다.					
		// 실제로 생성된 요청과 응답 메세지를 모두 확인하고 싶을 경우 andDo(ResultHandler handler) 메소드 사용.
		// MockMvcResultHandlers.print() 메소드는 ResultHandler를 구현한 객체를 리턴한다.
	}
*/
	
	@Test //내장톰캣으로 테스트하기
	public void testGetBoard() {
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터", board.getWriter());
	}
}
