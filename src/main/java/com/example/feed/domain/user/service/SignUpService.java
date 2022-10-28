package com.example.feed.domain.user.service;

import com.example.feed.domain.user.controller.dto.request.SignUpRequest;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.domain.repository.UserRepository;
import com.example.feed.domain.user.exception.UserAlreadyExistException;
import com.example.feed.domain.user.facade.AuthCodeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final AuthCodeFacade authCodeFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(SignUpRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        authCodeFacade.checkIsVerified(request.getEmail());

        userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .deviceToken(request.getDeviceToken())
                .build());
    }
}
