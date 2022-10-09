package com.example.feed.domain.user.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
