package com.example.feed.domain.board.controller;

import com.example.feed.domain.board.controller.dto.request.CreateBoardRequest;
import com.example.feed.domain.board.controller.dto.response.BoardDetailResponse;
import com.example.feed.domain.board.controller.dto.response.BoardListResponse;
import com.example.feed.domain.board.service.CreateBoardService;
import com.example.feed.domain.board.service.QueryBoardDetailService;
import com.example.feed.domain.board.service.QueryBoardListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

    private final CreateBoardService createBoardService;
    private final QueryBoardDetailService queryBoardDetailService;
    private final QueryBoardListService queryBoardListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody @Valid CreateBoardRequest request) {
        createBoardService.execute(request);
    }

    @GetMapping("/{board-id}")
    public BoardDetailResponse get(@PathVariable("board-id") Long id) {
        return queryBoardDetailService.execute(id);
    }

    @GetMapping
    public BoardListResponse getList() {
        return queryBoardListService.execute();
    }
}
