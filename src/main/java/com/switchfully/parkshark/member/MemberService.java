package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
   
   private final MemberRepository memberRepository;
   private final MemberMapper memberMapper;

   public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
      this.memberRepository = memberRepository;
      this.memberMapper = memberMapper;
   }

   public Member saveMember(Member member) {
      return memberRepository.save(member);
   }
   
   public Optional<Member> getMemberById(Long memberId) {
      return memberRepository.findById(memberId);
   }

   public List<MemberDto> getAllMembers() {
      return memberRepository.findAll().stream().map(memberMapper::toDto).toList();
   }
}
