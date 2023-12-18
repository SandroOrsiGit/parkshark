package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.dto.CreateMemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
   
   private final MemberRepository memberRepository;
   private final MemberMapper memberMapper;

   public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
      this.memberRepository = memberRepository;
      this.memberMapper = memberMapper;
   }

   public Member findMemberById(long id) {
      return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
   }
   
   public MemberDto saveMember(CreateMemberDto createMemberDto) {
      return memberMapper.mapMemberToMemberDto(memberRepository.save(memberMapper.mapCreateMemberDtoToMember(createMemberDto)));
   }
   
   public MemberDto getMemberById(Long memberId) {
      return memberMapper.mapMemberToMemberDto(memberRepository.findById(memberId)
              .orElseThrow(() -> new RuntimeException("Member not found with ID: " + memberId)));
   }

   public List<MemberDto> getAllMembers() {
      return memberRepository.findAll().stream().map(memberMapper::mapMemberToMemberDto).toList();
   }
}
