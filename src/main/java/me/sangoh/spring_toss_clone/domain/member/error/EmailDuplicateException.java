package me.sangoh.spring_toss_clone.domain.member.error;


import me.sangoh.spring_toss_clone.domain.model.Email;
import me.sangoh.spring_toss_clone.global.error.exception.InvalidValueException;

public class EmailDuplicateException extends InvalidValueException {

    public EmailDuplicateException(final Email email) {
        super(email.getValue(), MemberErrorCode.EMAIL_DUPLICATION);
    }
}
