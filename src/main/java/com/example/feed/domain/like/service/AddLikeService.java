package com.example.feed.domain.like.service;

import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.facade.FeedFacade;
import com.example.feed.domain.like.controller.dto.response.LikeResponse;
import com.example.feed.domain.like.domain.Likes;
import com.example.feed.domain.like.domain.repository.LikeJpaRepository;
import com.example.feed.domain.like.exception.LikeAlreadyExistException;
import com.example.feed.domain.like.facade.LikeFacade;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddLikeService {

    private final LikeJpaRepository likeJpaRepository;
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final LikeFacade likeFacade;
    private final MemberFacade memberFacade;

    @Transactional
    public LikeResponse execute(Long feedId) {

        User user = userFacade.getUser();
        Feed feed = feedFacade.getFeed(feedId);
        Member member = memberFacade.getMemberByBoardAndUser(feed.getBoard(), user);

        if (likeFacade.checkLiked(member, feed)) {
            throw LikeAlreadyExistException.EXCEPTION;
        }

        likeJpaRepository.save(Likes.builder()
                .member(member)
                .feed(feed)
                .build());
        feed.addLikeCounts();

        return new LikeResponse(feed.getLikeCounts());
    }
}
