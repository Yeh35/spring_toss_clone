package me.sangoh.spring_toss_clone.domain.store.error;

import lombok.AllArgsConstructor;
import me.sangoh.spring_toss_clone.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum StoreErrorCode implements ErrorCode {

    INVALID_INPUT_VALUE(HttpStatus.NOT_FOUND, "S001", "Not Find Store")
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
