package com.example.feed.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyInfoResponse {

    private String name;
    private String email;
    private String userProfileImage;
}
