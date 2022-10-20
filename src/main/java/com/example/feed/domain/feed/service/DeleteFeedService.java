package com.example.feed.domain.feed.service;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.domain.repository.FeedRepository;
import com.example.feed.domain.feed.facade.FeedFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedFacade feedFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Long feedId) {
        Feed feed = feedFacade.getFeed(feedId);

        feedRepository.delete(feed);
    }
}
