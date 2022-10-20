package com.example.feed.domain.feed.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "공백, 널 포함 불가, 1~20자 사이")
    private String title;

    @NotBlank
    @Size(min = 1, max = 20, message = "공백, 널 포함 불가, 1~1000자 사이")
    private String content;

    @NotNull(message = "널 포함 불가")
    private boolean nonMemberShowing;
}
