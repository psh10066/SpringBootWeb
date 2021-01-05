package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 어노테이션. @Controller, @controllerAdvice 등 사용
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입받는다
    private MockMvc mvc; // 웹 API 테스트할 때 사용한다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform의 결과 중 HTTP Header의 Status 검증 (isOk : 200인지 아닌지 검증)
                .andExpect(content().string(hello)); // mvc.perform의 결과 중 응답 본문의 내용 검증 (Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증)
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) // param : API 테스트할 때 사용될 요청 파라미터 설정 (String만 허용)
                        .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name))) // jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
                    .andExpect(jsonPath("$.amount", is(amount))); // $를 기준으로 필드명 명시

    }
}
