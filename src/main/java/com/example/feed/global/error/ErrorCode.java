package com.example.feed.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    IMAGE_UPLOAD_FAILED(400, "Image Upload Failed"),

    INVALID_PASSWORD(401, "invalid password"),
    BAD_AUTH_CODE(401, "Bad Auth Code"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    UNVERIFIED_EMAIL(401, "Unverified Email"),
    CANNOT_SEE_FEED(401, "Cannot See Feed"),

    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    USER_NOT_FOUND(404, "user not found"),
    MAIL_SEND_FAIL(404, "Mail Send Fail"),
    FEED_NOT_FOUND(404, "feed not found"),
    BOARD_NOT_FOUND(404, "board not found"),
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    COMMENT_NOT_FOUND(404, "Comment Not Found"),
    IMAGE_VALUE_NOT_FOUND(404, "Image Value Not Found"),

    USER_ALREADY_EXIST(409, "User Already Exist"),
    LIKE_ALREADY_EXIST(409, "Likes Already Exist"),
    FEED_NOT_LIKED(409, "feed not liked");

    private final int status;
    private final String message;
}
