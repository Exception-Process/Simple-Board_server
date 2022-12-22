package com.example.feed.domain.auth.controller;

import com.example.feed.domain.auth.controller.dto.request.LoginRequest;
import com.example.feed.domain.auth.controller.dto.response.TokenResponse;
import com.example.feed.domain.auth.service.LoginService;
import com.example.feed.domain.auth.service.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private final LoginService loginService;
    private final TokenRefreshService tokenRefreshService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @PutMapping("/reissue")
    public TokenResponse reissue(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }
}