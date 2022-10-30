package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.response.BoardDetailResponse;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.facade.BoardFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryBoardDetailService {

    private BoardFacade boardFacade;

    @Transactional(readOnly = true)
    public BoardDetailResponse execute(Long id) {

        Board board = boardFacade.getBoardById(id);

        return BoardDetailResponse.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .introduction(board.getIntroduction())
                .boardMemberCounts(board.getBoardMemberCounts())
                .adminName(board.getAdmin().getName())
                .imageUrl(board.getBoardProfileImage())
                .createdAt(board.getCreatedAt())
                .build();
    }
}
