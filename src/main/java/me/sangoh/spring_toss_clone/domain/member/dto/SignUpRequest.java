package me.sangoh.spring_toss_clone.domain.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sangoh.spring_toss_clone.domain.member.domain.Member;
import me.sangoh.spring_toss_clone.domain.member.domain.ReferralCode;
import me.sangoh.spring_toss_clone.domain.model.Email;
import me.sangoh.spring_toss_clone.domain.model.Name;

import javax.validation.Valid;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest {

    @Valid
    private Email email;

    @Valid
    private Name name;

    SignUpRequest(@Valid Email email, @Valid Name name) {
        this.email = email;
        this.name = name;
    }

    public Member toEntity(final ReferralCode referralCode) {
        return Member.builder()
                .name(name)
                .email(email)
                .referralCode(referralCode)
                .build();
    }
}
