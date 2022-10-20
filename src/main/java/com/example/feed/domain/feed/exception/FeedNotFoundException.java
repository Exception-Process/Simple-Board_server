package com.example.feed.domain.feed.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class FeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }
}
