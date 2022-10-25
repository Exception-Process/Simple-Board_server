package com.example.feed.domain.board.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class JoinBoardMemberRequest {

    @NotBlank
    @Size(min = 1, max = 20, message = "1~20자, NULL이나 공백 포함 불가")
    private String name;
}
