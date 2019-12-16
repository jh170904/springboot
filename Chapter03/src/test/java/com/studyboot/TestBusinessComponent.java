package com.studyboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.studyboot.service.BoardService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TestBusinessComponent {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BoardService boardService; //비즈니스 컴포넌트를 모킹해서 테스트하는 방법
	// @MockBean은 특정 타입의 객체를 모킹할 수 있다. 비즈니스 객체(BoardServiceImpl)을 생성하지 않고도 테스트 케이스 작성 가능
	
	@Test
	public void testHello() throws Exception {
		when(boardService.hello("hoho")).thenReturn("Hello : hoho");
		
		mockMvc.perform(get("/hello").param("name","hoho"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello : hoho"))
		.andDo(print());
	}
}
