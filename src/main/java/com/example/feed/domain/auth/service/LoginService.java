package com.example.feed.domain.auth.service;

import com.example.feed.domain.auth.controller.dto.request.LoginRequest;
import com.example.feed.domain.auth.controller.dto.response.TokenResponse;
import com.example.feed.domain.auth.exception.InvalidPasswordException;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import com.example.feed.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        User user = userFacade.getUserByEmail(email);

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw InvalidPasswordException.EXCEPTION;

        String accessToken = jwtTokenProvider.generateAccessToken(email);
        String refreshToken = jwtTokenProvider.generateRefreshToken(email);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
