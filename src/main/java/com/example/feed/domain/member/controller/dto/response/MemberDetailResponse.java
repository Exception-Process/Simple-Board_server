package com.example.feed.domain.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDetailResponse {

    private String userName;
    private String authority;
    private String memberName;
}
