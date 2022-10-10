package com.example.feed.domain.board.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "제목은 1~20자 사이여야되고, 공백이나 NULL을 포함할 수 없습니다.")
    private String title;

    @NotBlank
    @Size(min = 1, max = 100, message = "소개글은 1~100자 사이여야되고, 공백이나 NULL을 포함할 수 없습니다.")
    private String introduction;

}
