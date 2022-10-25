package com.example.feed.domain.board.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardRepository;
import com.example.feed.domain.board.exception.BadAdminException;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.board.controller.dto.request.PermitBoardMemberRequest;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberRepository;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PermitBoardMemberService {

    private final MemberFacade memberFacade;
    private final MemberRepository memberRepository;
    private final BoardFacade boardFacade;
    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public void execute(PermitBoardMemberRequest request) {

        User user = userFacade.getUser();
        Member member = memberFacade.getMemberById(request.getMemberId());
        Board board = boardFacade.getBoardByAdmin(user);

        if (!member.getBoard().equals(board))
            throw BadAdminException.EXCEPTION;

        member.permitJoin();
        board.addBoardMemberCounts();
        memberRepository.save(member);
        boardRepository.save(board);
    }
}
