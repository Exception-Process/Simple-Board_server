package com.example.feed.domain.auth.service;

import com.example.feed.domain.auth.controller.dto.response.TokenResponse;
import com.example.feed.domain.auth.domain.RefreshToken;
import com.example.feed.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.feed.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.feed.global.security.jwt.JwtProperty;
import com.example.feed.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperty jwtProperty;

    @Transactional
    public TokenResponse execute(String refreshToken) {

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String email = redisRefreshToken.getEmail();
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(email);

        redisRefreshToken.updateToken(newRefreshToken, jwtProperty.getRefreshExp());

        String newAccessToken = jwtTokenProvider.generateAccessToken(email);

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
