package com.example.feed.domain.feed.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FeedRepository {

    private final FeedJpaRepository feedJpaRepository;
}
