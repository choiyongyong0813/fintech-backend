package com.fintech.user.service;

import com.fintech.user.dto.UserSignupRequestDto;
import com.fintech.user.entity.User;
import com.fintech.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 사용자 비즈니스 로직을 담당하는 서비스 클래스입니다.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


     //회원가입 처리 메서드
     //@param dto 사용자 회원가입 요청 데이터
     //@return 처리 결과 메시지

    public String signup(UserSignupRequestDto dto) {

        // 이미 가입된 이메일인지 확인
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return "이미 가입된 이메일입니다.";
        }

        // User 엔티티 생성 및 저장
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // 비밀번호 암호화

        userRepository.save(user);

        return "회원가입 성공";
    }
}
