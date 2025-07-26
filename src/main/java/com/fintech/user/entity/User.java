package com.fintech.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//사용자 정보를 저장하는 Entity 클래스
//DB users 테이블과 매핑

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 기본 키
    private Long id;

    @Column(nullable = false, unique = true)
    private String email; // 사용자 이메일

    @Column(nullable = false)
    private String name; // 사용자 이름

    @Column(nullable = false)
    private String password; // 사용자 비밀번호
}
