package com.example.feed.domain.auth.service;

import com.example.feed.domain.user.controller.dto.request.SendAuthCodeRequest;
import com.example.feed.domain.user.exception.UserAlreadyExistException;
import com.example.feed.domain.user.facade.AuthCodeFacade;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendSignUpAuthCodeService {

    private final AuthCodeFacade authCodeFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(SendAuthCodeRequest request) {
        String email = request.getEmail();

        if (userFacade.emailIsExist(email)) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        authCodeFacade.sendMail(email);
    }
}
