package com.example.feed.domain.feed.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FeedElement {

    private Long feedId;
    private String title;
    private LocalDateTime createdAt;
    private String memberName;
}
