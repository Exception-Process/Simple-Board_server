package com.example.feed.domain.board.domain.repository;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByCreatedAtDesc();

    Optional<Board> findByAdmin(User admin);
}
