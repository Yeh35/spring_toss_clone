package me.sangoh.spring_toss_clone.domain.member.application;

import lombok.RequiredArgsConstructor;
import me.sangoh.spring_toss_clone.domain.member.dao.MemberRepository;
import me.sangoh.spring_toss_clone.domain.member.domain.Member;
import me.sangoh.spring_toss_clone.domain.member.domain.ReferralCode;
import me.sangoh.spring_toss_clone.domain.member.dto.SignUpRequest;
import me.sangoh.spring_toss_clone.domain.member.error.EmailDuplicateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberRepository memberRepository;

    public Member doSignUp(final SignUpRequest dto) {

        if (memberRepository.existsByEmail(dto.getEmail())) {
            throw new EmailDuplicateException(dto.getEmail());
        }

        final ReferralCode referralCode = generateUniqueReferralCode();
        return memberRepository.save(dto.toEntity(referralCode));
    }

    private ReferralCode generateUniqueReferralCode() {
        ReferralCode referralCode;
        do {
            referralCode = ReferralCode.generateCode();
        } while (memberRepository.existsByReferralCode(referralCode));

        return referralCode;
    }

}
