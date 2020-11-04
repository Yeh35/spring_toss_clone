package me.sangoh.spring_toss_clone.domain.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sangoh.spring_toss_clone.domain.member.domain.Member;
import me.sangoh.spring_toss_clone.domain.model.Email;
import me.sangoh.spring_toss_clone.domain.model.Name;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private Email email;

    private Name name;

    public MemberResponse(final Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
    }
}
