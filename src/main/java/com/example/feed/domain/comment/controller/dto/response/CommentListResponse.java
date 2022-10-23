package com.example.feed.domain.comment.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommentListResponse {

    private final List<CommentElement> commentList;
}
