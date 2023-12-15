package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
   
   private final MemberService memberService;
   
   public MemberController(MemberService memberService) {
      this.memberService = memberService;
   }
   
   
   @GetMapping(produces = "application/json")
   public List<MemberDto> getAllMembers() {
      return memberService.getAllMembers();
   }
}
