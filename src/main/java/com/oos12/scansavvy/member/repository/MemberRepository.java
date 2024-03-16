package com.oos12.scansavvy.member.repository;

import com.oos12.scansavvy.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
