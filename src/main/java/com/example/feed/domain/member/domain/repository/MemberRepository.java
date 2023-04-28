package com.example.feed.domain.member.domain.repository;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByBoardAndApproved(Board board, boolean join);
    Optional<Member> findByUserAndBoard(User user, Board board);
    List<Member> findAllByBoard(Board board);
}
