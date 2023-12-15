package com.switchfully.parkshark.manager.domain.dto;

public class ManagerDto {
   private long id = 1L;
   private final String username;
   private final String password;
   
   public ManagerDto(long id, String username, String password) {
      this.id = id;
      this.username = username;
      this.password = password;
   }
   
   public long getId() {
      return id;
   }
   
   public String getUsername() {
      return username;
   }
   
   public String getPassword() {
      return password;
   }
}
