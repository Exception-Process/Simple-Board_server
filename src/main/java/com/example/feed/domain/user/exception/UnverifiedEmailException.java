package com.example.feed.domain.user.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class UnverifiedEmailException extends CustomException {

    public static final CustomException EXCEPTION =
            new UnverifiedEmailException();

    private UnverifiedEmailException() {
        super(ErrorCode.UNVERIFIED_EMAIL);
    }
}
