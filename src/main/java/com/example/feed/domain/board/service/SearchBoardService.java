package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.request.SearchBoardRequest;
import com.example.feed.domain.board.controller.dto.response.BoardElement;
import com.example.feed.domain.board.controller.dto.response.BoardListResponse;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchBoardService {

    private final BoardJpaRepository boardJpaRepository;

    @Transactional(readOnly = true)
    public BoardListResponse execute(SearchBoardRequest request) {
        List<BoardElement> boardList = boardJpaRepository.findAllByTitleContaining(request.getSearch())
                .stream()
                .map(this::buildBoardList)
                .toList();

        return new BoardListResponse(boardList);
    }

    private BoardElement buildBoardList(Board board) {
        return BoardElement.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .adminName(board.getAdmin().getName())
                .boardMemberCounts(board.getBoardMemberCounts())
                .build();
    }
}
