package com.switchfully.parkshark.member;

import com.switchfully.parkshark.manager.ManagerService;
import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.dto.CreateMemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
   
   private final MemberService memberService;
   private final ManagerService managerService;
   
   public MemberController(MemberService memberService, ManagerService managerService) {
      this.memberService = memberService;
      this.managerService = managerService;
   }
   
   @GetMapping(produces = "application/json")
   public List<MemberDto> getAllMembers(@RequestHeader String username, @RequestHeader String password) {
      managerService.checkIfUserIsManager(username, password);

      return memberService.getAllMembers();
   }

   @GetMapping(produces = "application/json", path="{id}")
   public MemberDto getMemberById(@RequestHeader String username, @RequestHeader String password, @PathVariable long id) {
      managerService.checkIfUserIsManager(username, password);

      return memberService.getMemberById(id);
   }

   @ResponseStatus(HttpStatus.CREATED)
   @PostMapping(produces = "application/json", consumes = "application/json")
   public MemberDto createMember(@RequestBody CreateMemberDto createMemberDto) {
      return memberService.saveMember(createMemberDto);
   }
}
