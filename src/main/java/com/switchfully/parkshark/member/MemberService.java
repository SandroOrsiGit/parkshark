package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
   
   private final MemberRepository memberRepository;
   
   @Autowired
   public MemberService(MemberRepository memberRepository) {
      this.memberRepository = memberRepository;
   }
   
   public Member saveMember(Member member) {
      return memberRepository.save(member);
   }
   
   public Optional<Member> getMemberById(Long memberId) {
      return memberRepository.findById(memberId);
   }
}
