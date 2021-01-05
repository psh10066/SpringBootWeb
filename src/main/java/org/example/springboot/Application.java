package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 이 클래스는 항상 프로젝트의 최상단에 위치해야 함
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 모두 자동 설정
public class Application { // 앞으로 만들 프로젝트의 매인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
    }
}