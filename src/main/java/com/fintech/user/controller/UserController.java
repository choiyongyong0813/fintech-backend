package com.fintech.user.controller;

import com.fintech.user.dto.UserSignupRequestDto;
import com.fintech.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//사용자 관련 HTTP 요청을 처리하는 컨트롤러 클래스

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


     //[POST] /auth/signup
     //회원가입 요청 처리
     //@param dto 사용자 요청 DTO
     //@return 처리 결과 메시지

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserSignupRequestDto dto) {
        String result = userService.signup(dto);
        return ResponseEntity.ok(result);
    }
}
