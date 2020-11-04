package me.sangoh.spring_toss_clone.global.error.exception;

import me.sangoh.spring_toss_clone.global.error.CommonErrorCode;
import me.sangoh.spring_toss_clone.global.error.ErrorCode;

public class InvalidValueException extends BusinessException {

    public InvalidValueException(String value) {
        super(value, CommonErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }
}
