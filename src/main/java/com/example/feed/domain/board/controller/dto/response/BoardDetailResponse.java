package com.example.feed.domain.board.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardDetailResponse {

    private Long boardId;
    private String title;
    private String introduction;
    private String adminName;
    private LocalDateTime createdAt;
}
