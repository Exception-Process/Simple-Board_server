package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.request.CreateBoardRequest;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.board.domain.repository.BoardRepository;
import com.example.feed.domain.member.domain.repository.MemberRepository;
import com.example.feed.domain.member.domain.types.Authority;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateBoardService {

    private final UserFacade userFacade;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void execute(CreateBoardRequest request) {

        User user = userFacade.getUser();

        Board board = boardRepository.save(Board.builder()
                .title(request.getTitle())
                .introduction(request.getIntroduction())
                .boardMemberCounts(1)
                .boardProfileImage(request.getBoardProfileImage())
                .admin(user)
                .build()
        );

        memberRepository.save(Member.builder()
                .user(user)
                .board(board)
                .authority(Authority.ADMIN)
                .join(true)
                .name(request.getAdminName())
                .memberProfileImage(user.getUserProfileImage())
                .build()
        );
    }
}
