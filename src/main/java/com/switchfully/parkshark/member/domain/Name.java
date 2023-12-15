package com.switchfully.parkshark.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public final class Name {
   
   @Column(name = "FIRST_NAMe")
   private final String firstName;
   
   @Column(name = "LAST_NAME")
   private final String lastName;
   
   public Name() {
   }
   
   public Name(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public String getLastName() {
      return lastName;
   }
}
