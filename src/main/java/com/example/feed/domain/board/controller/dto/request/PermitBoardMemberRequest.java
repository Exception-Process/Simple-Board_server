package com.example.feed.domain.board.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PermitBoardMemberRequest {

    private Long memberId;
    private Long boardId;
}
