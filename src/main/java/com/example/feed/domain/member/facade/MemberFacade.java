package com.example.feed.domain.member.facade;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberJpaRepository;
import com.example.feed.domain.member.exception.MemberNotFoundException;
import com.example.feed.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberFacade {

    private final MemberJpaRepository memberJpaRepository;

    public Member getMemberById(Long id) {
        return memberJpaRepository.findById(id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

    public Member getMemberByBoardAndUser(Board board, User user) {
        return memberJpaRepository.findByUserAndBoard(user, board)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }
}
