package com.example.feed.domain.comment.service;

import com.example.feed.domain.comment.controller.dto.response.CommentElement;
import com.example.feed.domain.comment.controller.dto.response.CommentListResponse;
import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentJpaRepository;
import com.example.feed.domain.feed.domain.Feed;
import com.example.feed.domain.feed.facade.FeedFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryCommentListService {

    private final CommentJpaRepository commentJpaRepository;
    private final FeedFacade feedFacade;

    @Transactional(readOnly = true)
    public CommentListResponse execute(Long feedId) {
        Feed feed = feedFacade.getFeed(feedId);
        List<CommentElement> commentList = commentJpaRepository.findAllByFeedOrderByCreatedAtDesc(feed)
                .stream()
                .map(this::commentListBuild)
                .collect(Collectors.toList());

        return new CommentListResponse(commentList);
    }

    private CommentElement commentListBuild(Comment comment) {
        return CommentElement.builder()
                .commentId(comment.getId())
                .username(comment.getMember().getName())
                .content(comment.getComment())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}