package com.example.feed.domain.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberElement {

    private Long id;
    private String name;
    private String memberProfileImage;
}
