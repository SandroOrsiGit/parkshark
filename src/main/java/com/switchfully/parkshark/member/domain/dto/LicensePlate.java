package com.switchfully.parkshark.member.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

import java.util.Locale;

@Embeddable
public class LicensePlate {
   
   @Column(name = "license_plate_number")
   private String number;
   
   @Column(name = "license_plate_country")
   @Enumerated
   private Locale.IsoCountryCode country;
   
   public LicensePlate() {
   }
   
   public LicensePlate(String number, Locale.IsoCountryCode country) {
      this.number = number;
      this.country = country;
   }
   
   public String getNumber() {
      return number;
   }
   
   public Locale.IsoCountryCode getCountry() {
      return country;
   }
}
