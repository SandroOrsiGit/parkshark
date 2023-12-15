package com.switchfully.parkshark.member.domain.dto;

import com.switchfully.parkshark.member.domain.LicensePlate;
import com.switchfully.parkshark.member.domain.Name;
import com.switchfully.parkshark.address.domain.Address;

import java.time.LocalDate;

public class MemberDto {
   
   private Name name;
   private Address address;
   
   private String telephoneNumber;
   
   private String emailAddress;
   
   private LicensePlate licensePlate;
   
   private LocalDate registrationDate;
   
   public MemberDto(Name name, Address address, String telephoneNumber, String emailAddress, LicensePlate licensePlate, LocalDate registrationDate) {
      this.name = name;
      this.address = address;
      this.telephoneNumber = telephoneNumber;
      this.emailAddress = emailAddress;
      this.licensePlate = licensePlate;
      this.registrationDate = registrationDate;
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
}
