package com.example.feed.domain.feed.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.feed.controller.dto.request.CreateFeedRequest;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.domain.repository.FeedRepository;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final MemberFacade memberFacade;

    @Transactional
    public void execute(CreateFeedRequest request, Long boardId) {

        User user = userFacade.getUser();
        Board board = boardFacade.getBoardById(boardId);
        Member member = memberFacade.getMemberByBoardAndUser(board, user);

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .nonMemberShowing(request.isNonMemberShowing())
                .likeCounts(0)
                .feedImage(request.getImageUrl())
                .member(member)
                .board(board)
                .build());
    }
}
