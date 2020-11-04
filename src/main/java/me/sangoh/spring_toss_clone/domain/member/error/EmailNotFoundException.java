package me.sangoh.spring_toss_clone.domain.member.error;


import me.sangoh.spring_toss_clone.global.error.exception.EntityNotFoundException;

public class EmailNotFoundException extends EntityNotFoundException {

    public EmailNotFoundException(String target) {
        super(target + " is not found");
    }
}
