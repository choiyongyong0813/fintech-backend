package com.fintech.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


 //회원가입 요청을 받을 때 사용하는 DTO 클래스
 //유효성 검사를 위해 javax.validation 어노테이션 사용

@Getter
@Setter
public class UserSignupRequestDto {

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 유효하지 않습니다.")
    private String email;

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}
