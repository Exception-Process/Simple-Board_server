package com.example.feed.domain.user.controller;

import com.example.feed.domain.auth.controller.dto.request.LoginRequest;
import com.example.feed.domain.auth.controller.dto.response.TokenResponse;
import com.example.feed.domain.user.controller.dto.request.SignUpRequest;
import com.example.feed.domain.user.service.LoginService;
import com.example.feed.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final LoginService loginService;
    private final SignUpService signUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }
}
