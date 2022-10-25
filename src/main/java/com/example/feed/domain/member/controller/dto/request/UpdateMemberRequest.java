package com.example.feed.domain.member.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateMemberRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "공백이나 널을 포함할 수 없고, 1~20자여야 됩니다.")
    private String name;

    @NotBlank(message = "공백이나 널을 포함할 수 없다.")
    private String memberProfileImage;
}
