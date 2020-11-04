package me.sangoh.spring_toss_clone.global.error;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
