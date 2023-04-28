package com.example.feed.domain.comment.facade;

import com.example.feed.domain.comment.domain.Comment;
import com.example.feed.domain.comment.domain.repository.CommentJpaRepository;
import com.example.feed.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentJpaRepository commentJpaRepository;

    public Comment getComment(Long id) {
        return commentJpaRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
