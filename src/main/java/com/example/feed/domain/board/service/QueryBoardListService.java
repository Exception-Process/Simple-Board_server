package com.example.feed.domain.board.service;

import com.example.feed.domain.board.controller.dto.response.BoardListResponse;
import com.example.feed.domain.board.controller.dto.response.BoardElement;
import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.board.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryBoardListService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public BoardListResponse execute() {

        List<BoardElement> boardList = boardRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(this::buildBoardList)
                .collect(Collectors.toList());

        return new BoardListResponse(boardList);
    }

    private BoardElement buildBoardList(Board board) {
        return BoardElement.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .adminName(board.getAdmin().getName())
                .build();
    }
}
