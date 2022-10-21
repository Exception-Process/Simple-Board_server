package com.example.feed.domain.like.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class FeedNotLikedException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedNotLikedException();

    private FeedNotLikedException() {
        super(ErrorCode.FEED_NOT_LIKED);
    }
}
