package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.request.JoinBoardMemberRequest;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberJpaRepository;
import com.example.feed.domain.member.domain.types.Authority;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import com.example.feed.infrastructure.fcm.FCMFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class JoinBoardMemberService {

    private final MemberJpaRepository memberJpaRepository;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final FCMFacade fcmFacade;

    @Transactional
    public void execute(JoinBoardMemberRequest request, Long boardId) {
        User user = userFacade.getUser();
        Board board = boardFacade.getBoardById(boardId);

        Member member = memberJpaRepository.save(Member.builder()
                .board(board)
                .user(user)
                .name(request.getName())
                .authority(Authority.USER)
                .memberProfileImage(user.getUserProfileImage())
                .approved(false)
                .build()
        );

        fcmFacade.sendJoinNotification(member, board);
    }
}
