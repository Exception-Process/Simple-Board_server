package com.example.feed.domain.auth.controller;

import com.example.feed.domain.auth.controller.dto.request.LoginRequest;
import com.example.feed.domain.auth.controller.dto.response.LoginResponse;
import com.example.feed.domain.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private final LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public LoginResponse login(LoginRequest request) {
        return loginService.execute(request);
    }
}
