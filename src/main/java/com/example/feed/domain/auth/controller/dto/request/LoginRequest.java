package com.example.feed.domain.auth.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @Email(message = "이메일을 작성해야합니다.")
    private String email;

    @NotBlank(message = "비밀번호는 공백을 포함할 수 없습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,30}$", message = "비밀번호는는 8자에서 30자 사이입니다.")
    private String password;
}
