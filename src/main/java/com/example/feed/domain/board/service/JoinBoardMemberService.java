package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.request.JoinBoardMemberRequest;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberRepository;
import com.example.feed.domain.member.domain.types.Authority;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinBoardMemberService {

    private final MemberRepository memberRepository;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;

    public void execute(JoinBoardMemberRequest request, Long boardId) {

        User user = userFacade.getUser();
        Board board = boardFacade.getBoardById(boardId);

        memberRepository.save(Member.builder()
                .board(board)
                .user(user)
                .name(request.getName())
                .authority(Authority.USER)
                .join(false)
                .build()
        );
    }
}
