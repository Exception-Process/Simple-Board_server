package com.example.feed.domain.board.controller;

import com.example.feed.domain.board.controller.dto.request.CreateBoardRequest;
import com.example.feed.domain.board.controller.dto.request.JoinBoardMemberRequest;
import com.example.feed.domain.board.controller.dto.request.SearchBoardRequest;
import com.example.feed.domain.board.controller.dto.request.UpdateBoardRequest;
import com.example.feed.domain.board.controller.dto.response.BoardDetailResponse;
import com.example.feed.domain.board.controller.dto.response.BoardListResponse;
import com.example.feed.domain.board.service.CreateBoardService;
import com.example.feed.domain.board.service.DeleteBoardService;
import com.example.feed.domain.board.service.JoinBoardMemberService;
import com.example.feed.domain.board.service.PermitBoardMemberService;
import com.example.feed.domain.board.service.QueryBoardDetailService;
import com.example.feed.domain.board.service.QueryBoardListService;
import com.example.feed.domain.board.service.QueryBoardMemberService;
import com.example.feed.domain.board.service.QueryJoinBoardMemberService;
import com.example.feed.domain.board.service.SearchBoardService;
import com.example.feed.domain.board.service.UnPermitBoardMemberService;
import com.example.feed.domain.board.service.UpdateBoardService;
import com.example.feed.domain.member.controller.dto.response.MemberListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    private final QueryBoardMemberService queryBoardMemberService;
    private final QueryJoinBoardMemberService queryJoinBoardMemberService;
    private final SearchBoardService searchBoardService;
    private final UnPermitBoardMemberService unPermitBoardMemberService;


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
    @PatchMapping
    public void update(@RequestBody @Valid UpdateBoardRequest request) {
        updateBoardService.execute(request);
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
    @PostMapping("/permit/{member-id}")
    public void permit(@PathVariable("member-id") Long memberId) {
        permitBoardMemberService.execute(memberId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/permit/{member-id}")
    public void unPermit(@PathVariable("member-id") Long memberId) {
        unPermitBoardMemberService.execute(memberId);
    }

    @GetMapping("/member")
    public MemberListResponse getMemberList() {
        return queryBoardMemberService.execute();
    }

    @GetMapping("/search")
    public BoardListResponse searchList(@RequestBody @Valid SearchBoardRequest request) {
        return searchBoardService.execute(request);
    }

    @GetMapping("/join")
    public MemberListResponse joinMember() {
        return queryJoinBoardMemberService.execute();
    }
}