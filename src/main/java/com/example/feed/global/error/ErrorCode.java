package com.example.feed.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_EMAIL(400, "Bad Email Domain"),

    INVALID_PASSWORD(401, "invalid password"),
    EXPIRED_REFRESH_TOKEN(401, "Expired Refresh Token"),
    BAD_AUTH_CODE(401, "Bad Auth Code"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    INVALID_TOKEN(401, "Invalid Token"),
    UNVERIFIED_EMAIL(401, "Unverified Email"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),
    CANNOT_SEE_FEED(401, "Cannot See Feed"),
    BAD_ADMIN(401, "bad admin"),

    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    USER_NOT_FOUND(404, "user not found"),
    MAIL_SEND_FAIL(404, "Mail Send Fail"),
    FEED_NOT_FOUND(404, "feed not found"),
    BOARD_NOT_FOUND(404, "board not found"),
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    FEED_NOT_LIKED(404, "feed not liked"),

    USER_ALREADY_EXIST(409, "User Already Exist"),
    LIKE_ALREADY_EXIST(409, "Like Already Exist"),
    REMOVE_LIKE_EXIST(409, "Remove Like Exist"),

    INCORRECT_TOKEN(500, "Incorrect Token"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
