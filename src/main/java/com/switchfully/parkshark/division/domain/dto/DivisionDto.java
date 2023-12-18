package com.switchfully.parkshark.division.domain.dto;

public class DivisionDto {
   
   private final long id;
   
   public DivisionDto(long id, String divisionName, String originalName, String director) {
      this.id = id;
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
   }
   
   private final String divisionName;
   
   private final String originalName;
   
   private final String director;
   
  
   
   public long getId() {
      return id;
   }
   
   public String getDivisionName() {
      return divisionName;
   }
   
   public String getOriginalName() {
      return originalName;
   }
   
   public String getDirector() {
      return director;
   }
}
