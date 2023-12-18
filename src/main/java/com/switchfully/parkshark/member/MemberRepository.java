package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
   // add custom query methods if needed


    List<Member> findAll();
}
