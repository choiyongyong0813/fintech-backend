package com.fintech.user.repository;

import com.fintech.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//User 엔티티에 접근하기 위한 JPA 레포지토리 인터페이스입니다.
//기본 CRUD 기능을 포함하며, 이메일로 사용자 검색 기능도 정의합니다.

public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일로 사용자 조회 (회원가입 중복 확인 및 로그인에 사용)
    Optional<User> findByEmail(String email);
}
