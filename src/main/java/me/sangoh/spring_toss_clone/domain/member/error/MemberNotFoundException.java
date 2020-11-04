package me.sangoh.spring_toss_clone.domain.member.error;

import me.sangoh.spring_toss_clone.global.error.exception.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {

    public MemberNotFoundException(Long target) {
        super(target + " is not found");
    }
}
