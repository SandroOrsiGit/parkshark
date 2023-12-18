package com.switchfully.parkshark.member.domain;

import com.switchfully.parkshark.address.domain.Address;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER")
public class Member {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name= "member_id")
   private Long id;
   @Embedded
   private Name name;
   @OneToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "fk_address_id")
   private  Address address;
   @Column(name = "telephone_number")
   private String telephoneNumber;
   
   @Column(name = "email_address")
   private String emailAddress;
   
   @Embedded
   private LicensePlate licensePlate;
   
   @Column(name = "registration_date")
   private LocalDate registrationDate;

   @Enumerated(EnumType.STRING)
   @Column(name = "membership_level")
   private MembershipLevel membershipLevel;
   
   public Member() {
   }
   
   public Member(Name name, Address address, String telephoneNumber, String emailAddress, LicensePlate licensePlate, LocalDate date, MembershipLevel membershipLevel) {
      this.name = name;
      this.address = address;
      this.telephoneNumber = telephoneNumber;
      this.emailAddress = emailAddress;
      this.licensePlate = licensePlate;
      this.registrationDate = date;
      this.membershipLevel = membershipLevel;
   }
   
   public Member(Name name, Address address, String telephoneNumber, String emailAddress, LicensePlate licensePlate, MembershipLevel membershipLevel) {
      this.name = name;
      this.address = address;
      this.telephoneNumber = telephoneNumber;
      this.emailAddress = emailAddress;
      this.licensePlate = licensePlate;
      this.membershipLevel = membershipLevel;
      this.registrationDate = LocalDate.now();
   }
   
   public Long getId() {
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
   
   public LocalDate getDate() {
      return registrationDate;
   }

   public MembershipLevel getMembershipLevel() {
      return membershipLevel;
   }
   
   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Member member = (Member) o;
      return Objects.equals(id, member.id);
   }
   
   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
   
   @Override
   public String toString() {
      return "Member{" + "name=" + name + ", address=" + address + ", telephoneNumber='" + telephoneNumber + '\'' + ", emailAddress='" + emailAddress + '\'' + ", licensePlate='" + licensePlate + '\'' + ", date=" + registrationDate + '}';
   }
}
