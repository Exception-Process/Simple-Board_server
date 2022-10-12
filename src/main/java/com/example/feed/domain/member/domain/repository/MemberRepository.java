package com.example.feed.domain.member.domain.repository;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByBoardAndJoin(Board board, boolean join);
}
