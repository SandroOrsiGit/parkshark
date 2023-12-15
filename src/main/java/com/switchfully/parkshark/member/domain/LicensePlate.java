package com.switchfully.parkshark.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Locale;

@Embeddable
public class LicensePlate {
   
   @Column(name = "license_plate_number")
   private String number;
   
   @Column(name = "license_plate_country")

   private String country;
   
   public LicensePlate() {
   }
   
   public LicensePlate(String number, String country) {
      this.number = number;
      this.country = country;
   }
   
   public String getNumber() {
      return number;
   }
   
   public String getCountry() {
      return country;
   }
}
