package me.sangoh.spring_toss_clone.domain.member.error;

import lombok.AllArgsConstructor;
import me.sangoh.spring_toss_clone.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum MemberErrorCode implements ErrorCode {

    // Member
    EMAIL_DUPLICATION(  HttpStatus.BAD_REQUEST, "M001", "Email is Duplication"),
    LOGIN_INPUT_INVALID(HttpStatus.BAD_REQUEST, "M002", "Login input is invalid")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
