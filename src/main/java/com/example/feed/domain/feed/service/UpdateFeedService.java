package com.example.feed.domain.feed.service;

import com.example.feed.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.domain.repository.FeedJpaRepository;
import com.example.feed.domain.feed.facade.FeedFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final FeedFacade feedFacade;
    private final FeedJpaRepository feedJpaRepository;

    @Transactional
    public void execute(UpdateFeedRequest request, Long feedId) {

        String title = request.getTitle();
        String content = request.getContent();
        boolean nonMemberShowing = request.isNonMemberShowing();
        String imageUrl = request.getImageUrl();

        Feed feed = feedFacade.getFeed(feedId);

        feed.update(title, content, nonMemberShowing, imageUrl);
        feedJpaRepository.save(feed);
    }
}