package com.example.feed.domain.member.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberJpaRepository;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteMemberService {

    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final MemberFacade memberFacade;
    private final MemberJpaRepository memberJpaRepository;

    public void execute(Long boardId) {
        User user = userFacade.getUser();
        Board board = boardFacade.getBoardById(boardId);
        Member member = memberFacade.getMemberByBoardAndUser(board, user);

        memberJpaRepository.delete(member);
    }
}
