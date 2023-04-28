package com.example.feed.domain.auth.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {

    private final String accessToken;
    private final LocalDateTime accessExp;
    private final String refreshToken;
    private final LocalDateTime refreshExp;
}
