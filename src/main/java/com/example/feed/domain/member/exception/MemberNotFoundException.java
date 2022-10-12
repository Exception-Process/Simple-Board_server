package com.example.feed.domain.member.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class MemberNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new MemberNotFoundException();

    private MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
