package me.sangoh.spring_toss_clone.domain.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sangoh.spring_toss_clone.domain.model.Name;

import javax.validation.Valid;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MemberProfileUpdate {

    @Valid
    private Name name;

    public MemberProfileUpdate(@Valid Name name) {
        this.name = name;
    }
}
