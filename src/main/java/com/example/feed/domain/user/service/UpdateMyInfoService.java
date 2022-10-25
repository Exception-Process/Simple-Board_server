package com.example.feed.domain.user.service;

import com.example.feed.domain.user.controller.dto.request.UpdateMyInfoRequest;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.domain.repository.UserRepository;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateMyInfoService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateMyInfoRequest request) {

        User user = userFacade.getUser();

        user.updateUser(request.getEmail(), request.getName(), request.getUserProfileImage());
        userRepository.save(user);
    }
}
