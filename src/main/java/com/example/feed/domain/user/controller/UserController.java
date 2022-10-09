package com.example.feed.domain.user.controller;

import com.example.feed.domain.user.controller.dto.request.SendAuthCodeRequest;
import com.example.feed.domain.user.controller.dto.request.SignUpRequest;
import com.example.feed.domain.user.controller.dto.request.VerifyAuthCodeRequest;
import com.example.feed.domain.user.service.SendSignUpAuthCodeService;
import com.example.feed.domain.user.service.SignUpService;
import com.example.feed.domain.user.service.VerifyAuthCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final SendSignUpAuthCodeService sendSignUpAuthCodeService;
    private final VerifyAuthCodeService verifyAuthCodeService;
    private final SignUpService signUpService;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }
}
