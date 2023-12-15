package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
   // add custom query methods if needed
}
