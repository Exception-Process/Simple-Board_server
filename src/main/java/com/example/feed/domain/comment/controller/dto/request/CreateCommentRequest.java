package com.example.feed.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank
    @Size(min = 1, max = 300, message = "댓글은 1~300자 사이여야되고, NULL이나 공백을 포함할 수 없습니다.")
    private String comment;
}
