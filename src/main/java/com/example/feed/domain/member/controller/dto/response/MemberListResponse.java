package com.example.feed.domain.member.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MemberListResponse {

    private final List<MemberElement> memberList;
}
