package com.example.feed.domain.comment.facade;

import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentRepository;
import com.example.feed.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
