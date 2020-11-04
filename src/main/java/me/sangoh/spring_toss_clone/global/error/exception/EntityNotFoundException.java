package me.sangoh.spring_toss_clone.global.error.exception;

import me.sangoh.spring_toss_clone.global.error.CommonErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message, CommonErrorCode.ENTITY_NOT_FOUND);
    }
}
