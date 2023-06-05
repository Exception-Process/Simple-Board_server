package com.example.feed.domain.board.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class BoardNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new BoardNotFoundException();

    private BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
