package me.sangoh.spring_toss_clone.domain.member.dao;

import lombok.RequiredArgsConstructor;
import me.sangoh.spring_toss_clone.domain.member.domain.Member;
import me.sangoh.spring_toss_clone.domain.member.domain.ReferralCode;
import me.sangoh.spring_toss_clone.domain.member.dto.MemberExistenceType;
import me.sangoh.spring_toss_clone.domain.member.error.EmailNotFoundException;
import me.sangoh.spring_toss_clone.domain.member.error.MemberNotFoundException;
import me.sangoh.spring_toss_clone.domain.model.Email;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberFindDao {

    private final MemberRepository memberRepository;

    public Member findById(final Long id) {
        final Optional<Member> member = memberRepository.findById(id);
        member.orElseThrow(() -> new MemberNotFoundException(id));
        return member.get();
    }

    public Member findByEmail(final Email email) {
        final Optional<Member> member = memberRepository.findByEmail(email);
        member.orElseThrow(() -> new EmailNotFoundException(email.getValue()));
        return member.get();
    }


    public boolean isExistTarget(MemberExistenceType type, String value) {

        switch (type) {
            case EMAIL:
                Email email = Email.of(value);
                return memberRepository.existsByEmail(email);
            case REFERRAL_CODE:
                return memberRepository.existsByReferralCode(ReferralCode.of(value));
            default: // switch 문에서 Default는 기본!!
                assert false;
                return false;
        }
    }
}
