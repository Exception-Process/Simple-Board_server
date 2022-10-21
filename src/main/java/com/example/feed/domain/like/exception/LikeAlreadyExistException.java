package com.example.feed.domain.like.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class LikeAlreadyExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new LikeAlreadyExistException();

    private LikeAlreadyExistException() {
        super(ErrorCode.LIKE_ALREADY_EXIST);
    }
}
