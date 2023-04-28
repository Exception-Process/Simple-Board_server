package com.example.feed.domain.comment.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommentRepository {

    private final CommentJpaRepository commentJpaRepository;
}
