package com.example.feed.domain.member.service;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import com.example.feed.domain.member.controller.dto.response.MemberElement;
import com.example.feed.domain.member.controller.dto.response.MemberListResponse;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.domain.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryBoardMemberListService {

    private final MemberRepository memberRepository;
    private final BoardFacade boardFacade;

    public MemberListResponse execute(Long boardId) {

        Board board = boardFacade.getBoardById(boardId);

        List<MemberElement> memberList = memberRepository.findAllByBoard(board)
                .stream()
                .map(this::memberListBuilder)
                .collect(Collectors.toList());

        return new MemberListResponse(memberList);
    }

    private MemberElement memberListBuilder(Member member) {
        return MemberElement.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }
}
