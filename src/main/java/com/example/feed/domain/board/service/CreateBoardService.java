package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.request.CreateBoardRequest;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardJpaRepository;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberJpaRepository;
import com.example.feed.domain.member.domain.types.Authority;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateBoardService {

    private final UserFacade userFacade;
    private final BoardJpaRepository boardJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public void execute(CreateBoardRequest request) {
        User user = userFacade.getUser();

        Board board = boardJpaRepository.save(
                Board.builder()
                        .title(request.getTitle())
                        .introduction(request.getIntroduction())
                        .boardMemberCounts(1)
                        .boardProfileImage(request.getBoardProfileImage())
                        .admin(user)
                        .build()
        );

        memberJpaRepository.save(
                Member.builder()
                        .user(user)
                        .board(board)
                        .authority(Authority.ADMIN)
                        .approved(true)
                        .name(request.getAdminName())
                        .memberProfileImage(user.getUserProfileImage())
                        .build()
        );
    }
}
