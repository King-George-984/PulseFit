package com.pulsefit.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pulsefit.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}