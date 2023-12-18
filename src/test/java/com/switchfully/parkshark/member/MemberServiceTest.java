package com.switchfully.parkshark.member;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.member.domain.LicensePlate;
import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.MembershipLevel;
import com.switchfully.parkshark.member.domain.Name;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
   
   @Autowired
   private MemberService memberService;
   
   @Autowired
   private MemberRepository memberRepository;
   
   @Test
   void findMemberById_ShouldReturnMemberWhenFound() {
      
      Member expectedMember = new Member(new Name("firstname", "lastname"), new Address("testStreet", "22", new PostalCode("1700", "Brussels")), "0495454545", "tester@gmail.com", new LicensePlate("213456", "BE"), MembershipLevel.SILVER);
      
      memberRepository.save(expectedMember);
      
      Member actualMember = memberService.findMemberById(1);
      
      assertEquals(expectedMember, actualMember);
   }
   
}