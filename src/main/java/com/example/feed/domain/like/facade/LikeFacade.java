package com.example.feed.domain.like.facade;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.like.domain.Likes;
import com.example.feed.domain.like.domain.repository.LikeJpaRepository;
import com.example.feed.domain.like.exception.FeedNotLikedException;
import com.example.feed.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {

    private final LikeJpaRepository likeJpaRepository;

    public Likes getLike(Member member, Feed feed) {
        return likeJpaRepository.findByMemberAndFeed(member, feed)
                .orElseThrow(() -> FeedNotLikedException.EXCEPTION);
    }

    public boolean checkLiked(Member member, Feed feed) {
        return likeJpaRepository.existsByMemberAndFeed(member, feed);
    }
}
