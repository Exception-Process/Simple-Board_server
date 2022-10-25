package com.example.feed.domain.board.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardElement {

    private Long boardId;
    private String title;
    private String adminName;
    private Integer boardMemberCounts;
}
