package com.example.feed.domain.auth.controller;

import com.example.feed.domain.auth.controller.dto.response.TokenResponse;
import com.example.feed.domain.auth.service.SendSignUpAuthCodeService;
import com.example.feed.domain.auth.service.TokenRefreshService;
import com.example.feed.domain.auth.service.VerifyAuthCodeService;
import com.example.feed.domain.user.controller.dto.request.SendAuthCodeRequest;
import com.example.feed.domain.user.controller.dto.request.VerifyAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private final TokenRefreshService tokenRefreshService;
    private final SendSignUpAuthCodeService sendSignUpAuthCodeService;
    private final VerifyAuthCodeService verifyAuthCodeService;

    @PutMapping("/reissue")
    public TokenResponse reissue(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/code")
    public void sendAuthCode(@RequestBody @Valid SendAuthCodeRequest request) {
        sendSignUpAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/code")
    public void verifyAuthCode(@RequestBody @Valid VerifyAuthCodeRequest request) {
        verifyAuthCodeService.execute(request);
    }
}