package org.example.springboot.domain.posts;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복의 어노테이션 (롬복은 필수 어노테이션은 아니므로 주요 어노테이션을 클래스에 가깝게 두는 것이 좋다.) // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor // 롬복의 어노테이션 (이후 코틀린 등의 새 언어 전환으로 롬복이 더이상 필요 없을 경우 쉽게 삭제할 수 있다.) // 기본 생성자 자동 추가
@Entity // JPA의 어노테이션 // 테이블과 링크될 클래스임을 나타낸다. (기본적 이름 매칭 : SalesManager.java -> sales_manager table)
public class Posts extends BaseTimeEntity { // Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.

    @Id // 해당 필드의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙 (스프링 부트 2.0에서는 GenerationType.IDENTITY를 추가해야만 auto_increment가 된다)
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼. 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 되지만 추가로 변경이 필요한 옵션이 있으면 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
