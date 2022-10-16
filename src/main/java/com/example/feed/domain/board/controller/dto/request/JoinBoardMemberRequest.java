package com.example.feed.domain.board.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class JoinBoardMemberRequest {

    @Size(min = 1, max = 20)
    private String name;
}
