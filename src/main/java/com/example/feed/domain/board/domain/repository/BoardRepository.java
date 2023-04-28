package com.example.feed.domain.board.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final BoardJpaRepository boardJpaRepository;
}
