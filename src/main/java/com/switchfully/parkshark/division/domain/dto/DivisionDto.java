package com.switchfully.parkshark.division.domain.dto;

public class DivisionDto {
   
   private final String divisionName;
   
   private final String originalName;
   
   private final String director;

   private long parentId;
   
   public DivisionDto(String divisionName, String originalName, String director) {
      
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
   }

   public DivisionDto(String divisionName, String originalName, String director, long parentId) {
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
      this.parentId = parentId;
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

   public long getParentId() {
      return parentId;
   }
}
