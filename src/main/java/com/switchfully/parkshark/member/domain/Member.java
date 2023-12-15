package com.switchfully.parkshark.member.domain;

import com.switchfully.parkshark.parking_lot.domain.Address;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class Member {
   
   @Embedded
   private Name name;
   private Address adress;
   
   private String telephoneNumber;
   
   private String emailAdress;
   
   private String licensePlate;
   
   private LocalDate date;
   
   public Member(Name name, Address adress, String telephoneNumber, String emailAdress, String licensePlate, LocalDate date) {
      this.name = name;
      this.adress = adress;
      this.telephoneNumber = telephoneNumber;
      this.emailAdress = emailAdress;
      this.licensePlate = licensePlate;
      this.date = date;
   }
   
   public Name getName() {
      return name;
   }
   
   public Address getAdress() {
      return adress;
   }
   
   public String getTelephoneNumber() {
      return telephoneNumber;
   }
   
   public String getEmailAdress() {
      return emailAdress;
   }
   
   public String getLicensePlate() {
      return licensePlate;
   }
   
   public LocalDate getDate() {
      return date;
   }
   
   @Override
   public String toString() {
      return "Member{" + "name=" + name + ", adress=" + adress + ", telephoneNumber='" + telephoneNumber + '\'' + ", emailAdress='" + emailAdress + '\'' + ", licensePlate='" + licensePlate + '\'' + ", date=" + date + '}';
   }
}
