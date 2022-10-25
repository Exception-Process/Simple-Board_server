package com.example.feed.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateMyInfoRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "이름은 공백이나 널을 포함할 수 없고, 1~20자 사이입니다.")
    private String name;

    @Email
    private String email;

    @NotBlank(message = "공백이나 널을 포함 할 수 없습니다.")
    private String userProfileImage;
}
