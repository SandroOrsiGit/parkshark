package com.switchfully.parkshark.member.domain;

import com.switchfully.parkshark.member.domain.dto.LicensePlate;
import com.switchfully.parkshark.parking_lot.domain.Address;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
public class Member {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Embedded
   private Name name;
   @OneToOne
   @JoinColumn(name = "fk_address_id")
   private  Address address;
   @Column(name = "telephone_number")
   private String telephoneNumber;
   
   @Column(name = "email_address")
   private String emailAddress;
   
   @Embedded
   private LicensePlate licensePlate;
   
   @Column(name = "registrationDate")
   private LocalDate registrationDate;
   
   public Member() {
   }
   
   public Member(Name name, Address address, String telephoneNumber, String emailAddress, LicensePlate licensePlate, LocalDate date) {
      this.name = name;
      this.address = address;
      this.telephoneNumber = telephoneNumber;
      this.emailAddress = emailAddress;
      this.licensePlate = licensePlate;
      this.registrationDate = date;
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
   
   public LocalDate getDate() {
      return registrationDate;
   }
   
   @Override
   public String toString() {
      return "Member{" + "name=" + name + ", address=" + address + ", telephoneNumber='" + telephoneNumber + '\'' + ", emailAddress='" + emailAddress + '\'' + ", licensePlate='" + licensePlate + '\'' + ", date=" + registrationDate + '}';
   }
}
