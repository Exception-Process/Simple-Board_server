package com.example.feed.domain.board.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class BadAdminException extends CustomException {

    public static final CustomException EXCEPTION =
            new BadAdminException();

    private BadAdminException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
