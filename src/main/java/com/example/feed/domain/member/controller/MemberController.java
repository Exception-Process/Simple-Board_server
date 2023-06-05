package com.example.feed.domain.member.controller;

import com.example.feed.domain.member.controller.dto.response.MemberDetailResponse;
import com.example.feed.domain.member.service.DeleteMemberService;
import com.example.feed.domain.member.service.QueryMyMemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
