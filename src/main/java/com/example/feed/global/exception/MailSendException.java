package com.example.feed.global.exception;

import com.example.feed.global.error.CustomException;
import com.example.feed.global.error.ErrorCode;

public class MailSendException extends CustomException {

    public static final CustomException EXCEPTION =
            new MailSendException();

    private MailSendException() {
        super(ErrorCode.MAIL_SEND_FAIL);
    }
}
