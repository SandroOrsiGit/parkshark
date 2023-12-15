package com.switchfully.parkshark.member.domain.dto;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.member.domain.LicensePlate;
import com.switchfully.parkshark.member.domain.Name;

public class CreateMemberDto {
   private Name name;
   private Address address;
   
   private String telephoneNumber;
   
   private String emailAddress;
   
   private LicensePlate licensePlate;
   
   public CreateMemberDto (Name name, Address address, String telephoneNumber, String emailAddress, LicensePlate licensePlate) {
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
   
   public LicensePlate getLicensePlate() {
      return licensePlate;
   }
}
