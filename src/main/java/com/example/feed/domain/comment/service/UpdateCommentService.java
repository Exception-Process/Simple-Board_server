package com.example.feed.domain.comment.service;

import com.example.feed.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentRepository;
import com.example.feed.domain.comment.facade.CommentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateCommentService {

    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    public void execute(Long commentId, UpdateCommentRequest request) {

        Comment comment = commentFacade.getComment(commentId);

        comment.update(request.getComment());
        commentRepository.save(comment);
    }
}
