package com.switchfully.parkshark.member;

import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.dto.CreateMemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

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
   
   @PostMapping(produces = "application/json", consumes = "application/json")
   public MemberDto createMember(@RequestBody CreateMemberDto createMemberDto) {
      return memberService.saveMember(createMemberDto);
   }
}
