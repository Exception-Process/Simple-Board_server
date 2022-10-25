package com.example.feed.domain.board.controller;

import com.example.feed.domain.board.controller.dto.request.*;
import com.example.feed.domain.board.controller.dto.response.BoardDetailResponse;
import com.example.feed.domain.board.controller.dto.response.BoardListResponse;
import com.example.feed.domain.board.service.*;
import com.example.feed.domain.board.service.PermitBoardMemberService;
import com.example.feed.domain.member.controller.dto.response.MemberListResponse;
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
    private final UpdateBoardService updateBoardService;
    private final DeleteBoardService deleteBoardService;
    private final JoinBoardMemberService joinBoardMemberService;
    private final PermitBoardMemberService permitBoardMemberService;
    private final QueryJoinBoardMemberService queryJoinBoardMemberService;
    private final SearchBoardService searchBoardService;


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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{board-id}")
    public void update(@RequestBody @Valid UpdateBoardRequest request, @PathVariable("board-id") Long id) {
        updateBoardService.execute(request, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{board-id}")
    public void delete(@PathVariable("board-id") Long id) {
        deleteBoardService.execute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/join/{board-id}")
    public void join(@RequestBody @Valid JoinBoardMemberRequest request, @PathVariable("board-id") Long boardId) {
        joinBoardMemberService.execute(request, boardId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/permit")
    public void permit(@RequestBody @Valid PermitBoardMemberRequest request) {
        permitBoardMemberService.execute(request);
    }

    @GetMapping("/join/member")
    public MemberListResponse getJoinMemberList() {
        return queryJoinBoardMemberService.execute();
    }

    @GetMapping("/search")
    public BoardListResponse searchList(@RequestBody @Valid SearchBoardRequest request) {
        return searchBoardService.execute(request);
    }
}
