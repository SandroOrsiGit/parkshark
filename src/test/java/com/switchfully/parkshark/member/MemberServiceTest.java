package com.switchfully.parkshark.member;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.member.domain.LicensePlate;
import com.switchfully.parkshark.member.domain.Member;
import com.switchfully.parkshark.member.domain.MembershipLevel;
import com.switchfully.parkshark.member.domain.Name;
import com.switchfully.parkshark.member.domain.dto.CreateMemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
   
   @Autowired
   private MemberService memberService;
   
   @Autowired
   private MemberRepository memberRepository;
   @Autowired
   private MemberMapper memberMapper;
   
   @Test
   void givenMember_whenSaveMemberinDatabase_thenMemberDtoFromDatabaseReturnsWithSameFields() {
      //GIVEN
      CreateMemberDto createMemberDto = new CreateMemberDto(
              new Name("firstname", "lastname"),
              new Address("testStreet", "22",
                      new PostalCode("1700", "Bruffelf")),
              "0495454545", "tester@gmail.com",
              new LicensePlate("213456", "BE"));

      //WHEN
      MemberDto memberDto = memberService.saveMember(createMemberDto);

              //THEN
      assertThat(memberDto.getAddress().getPostalCode().getLocation()).isEqualTo("Bruffelf");
      assertThat(memberDto.getAddress().getPostalCode().getPostalCode()).isEqualTo("1700");
      assertThat(memberDto.getLicensePlate().getCountry()).isEqualTo("BE");
      assertThat(memberDto.getMembershipLevel()).isEqualTo(MembershipLevel.BRONZE);
      assertThat(memberService.getAllMembers()).hasSize(1);
   }

   @Test
   void givenMemberInDatabase_whenFindMemberById_thenReturnThisMember() {
      //GIVEN
      CreateMemberDto createMemberDto = new CreateMemberDto(
              new Name("firstname", "lastname"),
              new Address("testStreet", "22",
                      new PostalCode("1700", "Brussels")),
              "0495454545", "tester@gmail.com",
              new LicensePlate("testingfornumber", "BE"),
              MembershipLevel.SILVER);

      //WHEN
      MemberDto memberDto = memberService.saveMember(createMemberDto);

      //THEN
      assertThat(memberService.findMemberById(memberDto.getId()).getLicensePlate().getNumber())
              .isEqualTo("testingfornumber");
      assertThat(memberService.getAllMembers()).hasSize(1);
   }

   @Test
   void givenMember_whenSaveMember_thenMemberIsSavedToDatabase() {
      //GIVEN
      CreateMemberDto createMemberDto = new CreateMemberDto(
              new Name("firstname", "lastname"),
              new Address("testStreet", "22",
                      new PostalCode("1700", "Brussels")),
              "0495454545", "tester@gmail.com",
              new LicensePlate("213456", "BE"),
              MembershipLevel.SILVER);

      //WHEN
      MemberDto memberDto = memberService.saveMember(createMemberDto);

      //THEN
      assertThat(memberService.getMemberById(memberDto.getId()).getName().getFirstName())
              .isEqualTo(memberMapper.mapCreateMemberDtoToMember(createMemberDto).getName().getFirstName());
      assertThat(memberService.getAllMembers()).hasSize(1);
      assertThat(memberDto.getMembershipLevel()).isEqualTo(createMemberDto.getMembershipLevel());
   }

   @Test
   void givenThreeMembersInDatabase_whenGetAllMembers_thenReturnAllTheseMembers() {
      //GIVEN
      CreateMemberDto createMemberDto1 = new CreateMemberDto(
              new Name("firstname", "lastname"),
              new Address("testStreet", "22",
                      new PostalCode("1700", "Brussels")),
              "0495454545", "tester@gmail.com",
              new LicensePlate("213456", "BE"),
              MembershipLevel.SILVER);

      memberService.saveMember(createMemberDto1);

      CreateMemberDto createMemberDto2 = new CreateMemberDto(
              new Name("first", "last"),
              new Address("testStreetagain", "545",
                      new PostalCode("1730", "Antwerpen")),
              "049333345", "testagain@gmail.com",
              new LicensePlate("11111", "UK"));

      memberService.saveMember(createMemberDto2);

      CreateMemberDto createMemberDto3 = new CreateMemberDto(
              new Name("thirdtestfirst", "thirdtestlast"),
              new Address("testStreetagain", "332",
                      new PostalCode("1230", "Antwerpen")),
              "0333345", "testzzzin@gmail.com",
              new LicensePlate("11111", "UK"),
              MembershipLevel.GOLD);

      memberService.saveMember(createMemberDto3);

      //WHEN
      List<MemberDto> memberDtoList = memberService.getAllMembers();

      //THEN
      assertThat(memberDtoList).allSatisfy(memberDto -> assertThat(memberDto).isInstanceOf(MemberDto.class));
      assertThat(memberDtoList)
              .hasSize(3)
              .extracting(memberDto -> memberDto.getName().getFirstName())
              .containsExactly("firstname", "first", "thirdtestfirst");
      assertThat(memberDtoList)
              .extracting(MemberDto::getEmailAddress)
              .containsExactly("tester@gmail.com", "testagain@gmail.com", "testzzzin@gmail.com");
      assertThat(memberDtoList)
              .extracting(MemberDto::getMembershipLevel)
              .containsExactly(MembershipLevel.SILVER, MembershipLevel.BRONZE, MembershipLevel.GOLD);


   }


   
}