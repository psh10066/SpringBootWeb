package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts, Long> { // JpaRepository<Entity 클래스, PK 타입> 상속하면 기본적인 CRUD 메소드 자동 생성

}
