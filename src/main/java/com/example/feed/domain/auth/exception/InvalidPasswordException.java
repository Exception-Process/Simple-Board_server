package com.example.feed.domain.auth.exception;

import com.example.feed.domain.user.exception.UserAlreadyExistException;
import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;
import com.example.feed.global.exception.InvalidJwtException;

public class InvalidPasswordException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
