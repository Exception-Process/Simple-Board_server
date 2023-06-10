package com.example.feed.domain.member.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.member.controller.dto.response.MemberDetailResponse;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.facade.MemberFacade;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryMyMemberInfoService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final MemberFacade memberFacade;

    public MemberDetailResponse execute(Long boardId) {
        User user = userFacade.getUser();
        Board board = boardFacade.getBoardById(boardId);
        Member member = memberFacade.getMemberByBoardAndUser(board, user);

        return MemberDetailResponse
                .builder()
                .userName(user.getName())
                .authority(member.getAuthority().toString())
                .memberName(member.getName())
                .build();
    }
}
