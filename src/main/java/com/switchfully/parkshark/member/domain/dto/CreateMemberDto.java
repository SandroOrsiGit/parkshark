package com.switchfully.parkshark.member.domain.dto;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.member.domain.Name;


public class CreateMemberDto {
   private Name name;
   private Address address;
   
   private String telephoneNumber;
   
   private String emailAddress;
   
   private String licensePlate;
   
   public CreateMemberDto(Name name, Address address, String telephoneNumber, String emailAddress, String licensePlate) {
      this.name = name;
      this.address = address;
      this.telephoneNumber = telephoneNumber;
      this.emailAddress = emailAddress;
      this.licensePlate = licensePlate;
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
   
   public String getLicensePlate() {
      return licensePlate;
   }
}
