package com.example.feed.infrastructure.image.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class ImageUploadFailedException extends CustomException {

    public static final CustomException EXCEPTION =
            new ImageUploadFailedException();

    private ImageUploadFailedException() {
        super(ErrorCode.IMAGE_UPLOAD_FAILED);
    }

}
