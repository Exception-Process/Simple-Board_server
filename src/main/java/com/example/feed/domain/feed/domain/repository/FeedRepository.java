package com.example.feed.domain.feed.domain.repository;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    List<Feed> findAllByBoard(Board board);

    Optional<Feed> findByIdAndBoard(Long id, Board board);
}
