package com.example.feed.domain.feed.service;

import com.example.feed.domain.feed.controller.dto.response.FeedDetailResponse;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.exception.CannotSeeFeedException;
import com.example.feed.domain.feed.facade.FeedFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryFeedDetailService {

    private final FeedFacade feedFacade;

    @Transactional(readOnly = true)
    public FeedDetailResponse execute(Long feedId) {

        Feed feed = feedFacade.getFeed(feedId);

        if (!feed.isNonMemberShowing())
            throw CannotSeeFeedException.EXCEPTION;

        return FeedDetailResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .memberName(feed.getMember().getName())
                .createdAt(feed.getCreatedAt())
                .imageUrl(feed.getFeedImage())
                .build();
    }
}
