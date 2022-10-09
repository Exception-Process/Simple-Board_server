package com.example.feed.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class SendAuthCodeRequest {

    @Email
    private String email;
}
