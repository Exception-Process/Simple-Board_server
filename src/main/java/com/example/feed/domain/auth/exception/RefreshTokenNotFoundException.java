package com.example.feed.domain.auth.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class RefreshTokenNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
