package com.switchfully.parkshark.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public final class Name {
   
   @Column(name = "first_name")
   private String firstName;
   
   @Column(name = "last_name")
   private String lastName;
   
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
