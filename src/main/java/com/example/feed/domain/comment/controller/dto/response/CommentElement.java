package com.example.feed.domain.comment.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentElement {

    private Long commentId;
    private String username;
    private String content;
    private LocalDateTime createdAt;
}
