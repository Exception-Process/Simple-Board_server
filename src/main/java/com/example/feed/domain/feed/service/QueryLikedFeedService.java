package com.example.feed.domain.feed.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.feed.controller.dto.response.FeedElement;
import com.example.feed.domain.feed.controller.dto.response.FeedListResponse;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.like.domain.Like;
import com.example.feed.domain.like.domain.repository.LikeRepository;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryLikedFeedService {

    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final MemberFacade memberFacade;

    @Transactional(readOnly = true)
    public FeedListResponse execute(Long boardId) {

        User user = userFacade.getUser();
        Board board = boardFacade.getBoardById(boardId);
        Member member = memberFacade.getMemberByBoardAndUser(board, user);

        List<FeedElement> feedList = likeRepository.findAllByMember(member)
                .stream()
                .map(this::feedListBuild)
                .collect(Collectors.toList());

        return new FeedListResponse(feedList);
    }

    private FeedElement feedListBuild(Like like) {
        return FeedElement.builder()
                .feedId(like.getFeed().getId())
                .title(like.getFeed().getTitle())
                .memberName(like.getMember().getName())
                .createdAt(like.getFeed().getCreatedAt())
                .build();
    }
}
