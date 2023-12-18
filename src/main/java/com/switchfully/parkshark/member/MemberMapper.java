package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.dto.CreateMemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
   public MemberDto mapMemberToMemberDto(Member member) {
      return new MemberDto(member.getName(), member.getAddress(), member.getTelephoneNumber(), member.getEmailAddress(), member.getLicensePlate(), member.getDate(), member.getMembershipLevel());
   }
   
   public Member mapCreateMemberDtoToMember(CreateMemberDto createMemberDto) {
      return new Member(createMemberDto.getName(), createMemberDto.getAddress(), createMemberDto.getTelephoneNumber(), createMemberDto.getEmailAddress(), createMemberDto.getLicensePlate(), createMemberDto.getMembershipLevel());
   }
}
