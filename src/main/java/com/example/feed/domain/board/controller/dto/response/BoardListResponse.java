package com.example.feed.domain.board.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoardListResponse {

    private final List<BoardElement> boardList;
}
