package com.switchfully.parkshark.member.domain.dto;

import com.switchfully.parkshark.member.domain.LicensePlate;
import com.switchfully.parkshark.member.domain.MembershipLevel;
import com.switchfully.parkshark.member.domain.Name;
import com.switchfully.parkshark.address.domain.Address;

import java.time.LocalDate;

public class MemberDto {

   private long id;
   private Name name;
   private Address address;
   
   private String telephoneNumber;
   
   private String emailAddress;
   
   private LicensePlate licensePlate;
   
   private LocalDate registrationDate;

   private MembershipLevel membershipLevel;
   
   public MemberDto(long id, Name name, Address address, String telephoneNumber, String emailAddress, LicensePlate licensePlate, LocalDate registrationDate, MembershipLevel membershipLevel) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.telephoneNumber = telephoneNumber;
      this.emailAddress = emailAddress;
      this.licensePlate = licensePlate;
      this.registrationDate = registrationDate;
      this.membershipLevel = membershipLevel;
   }

   public long getId() {
      return id;
   }

   public Name getName() {
      return name;
   }
   
   public Address getAddress() {
      return address;
   }
   
   public String getTelephoneNumber() {
      return telephoneNumber;
   }
   
   public String getEmailAddress() {
      return emailAddress;
   }
   
   public LicensePlate getLicensePlate() {
      return licensePlate;
   }
   
   public LocalDate getRegistrationDate() {
      return registrationDate;
   }

   public MembershipLevel getMembershipLevel() {
      return membershipLevel;
   }
}
