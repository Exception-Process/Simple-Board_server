package com.example.feed.domain.board.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SearchBoardRequest {

    @NotBlank(message = "NULL이나 공백 포함 불가")
    private String search;
}
