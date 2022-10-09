package com.example.feed.domain.user.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class BadEmailException extends CustomException {

    public static final CustomException EXCEPTION =
            new BadEmailException();

    private BadEmailException() {
        super(ErrorCode.BAD_EMAIL);
    }
}
