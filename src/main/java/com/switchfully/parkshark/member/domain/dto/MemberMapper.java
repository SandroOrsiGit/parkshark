package com.switchfully.parkshark.member.domain.dto;

import com.switchfully.parkshark.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getName(),
                member.getAddress(),
                member.getTelephoneNumber(),
                member.getEmailAddress(),
                member.getLicensePlate());
    }
}
