package com.example.feed.domain.comment.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentRepository;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.facade.FeedFacade;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final MemberFacade memberFacade;
    private final FeedFacade feedFacade;

    public void execute(CreateCommentRequest request, Long feedId) {

        User user = userFacade.getUser();
        Feed feed = feedFacade.getFeed(feedId);
        Member member = memberFacade.getMemberByBoardAndUser(feed.getBoard(), user);

        commentRepository.save(Comment.builder()
                .member(member)
                .feed(feed)
                .comment(request.getComment())
                .build());
    }
}
