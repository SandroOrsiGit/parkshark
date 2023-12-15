package com.switchfully.parkshark.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
   
   private final MemberService memberService;
   
   public MemberController(MemberService memberService) {
      this.memberService = memberService;
   }
   
   
   
}
