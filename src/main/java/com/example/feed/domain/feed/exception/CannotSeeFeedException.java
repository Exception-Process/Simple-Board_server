package com.example.feed.domain.feed.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class CannotSeeFeedException extends CustomException {

    public static final CustomException EXCEPTION =
            new CannotSeeFeedException();

    private CannotSeeFeedException() {
        super(ErrorCode.CANNOT_SEE_FEED);
    }
}
