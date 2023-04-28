package com.example.feed.domain.auth.service;

import com.example.feed.domain.user.controller.dto.request.VerifyAuthCodeRequest;
import com.example.feed.domain.user.facade.AuthCodeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VerifyAuthCodeService {

    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(VerifyAuthCodeRequest request) {
        authCodeFacade.verifyAuthCode(request.getAuthCode(), request.getEmail());
    }
}
