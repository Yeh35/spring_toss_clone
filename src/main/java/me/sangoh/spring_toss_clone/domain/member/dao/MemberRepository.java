package me.sangoh.spring_toss_clone.domain.member.dao;

import me.sangoh.spring_toss_clone.domain.member.domain.Member;
import me.sangoh.spring_toss_clone.domain.member.domain.ReferralCode;
import me.sangoh.spring_toss_clone.domain.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByEmail(Email email);

  boolean existsByEmail(Email email);

  boolean existsByReferralCode(ReferralCode referralCode);

}
