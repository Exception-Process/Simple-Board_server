package com.example.feed.domain.comment.service;

import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentJpaRepository;
import com.example.feed.domain.comment.facade.CommentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {

    private final CommentFacade commentFacade;
    private final CommentJpaRepository commentJpaRepository;

    public void execute(Long commentId) {
        Comment comment = commentFacade.getComment(commentId);
        commentJpaRepository.delete(comment);
    }
}
