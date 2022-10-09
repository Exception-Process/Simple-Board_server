package com.example.feed.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 2, max = 10, message = "이름은 공백을 포함할 수 없고, 2자에서 10자 사이입니다.")
    private String name;

    @NotBlank(message = "비밀번호는 공백을 포함할 수 없습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,30}$", message = "비밀번호는는 8자에서 30자 사이입니다.")
    private String password;

}
