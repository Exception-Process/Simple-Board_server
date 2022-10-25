package com.example.feed.domain.user.service;

import com.example.feed.domain.user.controller.dto.response.MyInfoResponse;
import com.example.feed.domain.user.domain.User;
import com.example.feed.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyInfoService {

    private UserFacade userFacade;

    @Transactional(readOnly = true)
    public MyInfoResponse execute() {
        User user = userFacade.getUser();

        return MyInfoResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .userProfileImage(user.getUserProfileImage())
                .build();
    }
}
