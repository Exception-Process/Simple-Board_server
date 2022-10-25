package com.example.feed.infrastructure.image.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class ImageValueNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new ImageValueNotFoundException();

    private ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}
