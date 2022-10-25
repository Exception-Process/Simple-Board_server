package com.example.feed.domain.member.controller;

import com.example.feed.domain.member.controller.dto.response.MemberDetailResponse;
import com.example.feed.domain.member.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

    private final DeleteMemberService deleteMemberService;
    private final QueryMyMemberInfoService queryMyMemberInfoService;

    @DeleteMapping("/{board-id}")
    public void delete(@PathVariable("board-id") Long boardId) {
        deleteMemberService.execute(boardId);
    }

    @GetMapping("/{board-id}")
    public MemberDetailResponse get(@PathVariable("board-id") Long boardId) {
        return queryMyMemberInfoService.execute(boardId);
    }
}
