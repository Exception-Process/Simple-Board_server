package com.example.feed.domain.feed.facade;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.domain.repository.FeedJpaRepository;
import com.example.feed.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedJpaRepository feedJpaRepository;

    public Feed getFeed(Long id) {
        return feedJpaRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
