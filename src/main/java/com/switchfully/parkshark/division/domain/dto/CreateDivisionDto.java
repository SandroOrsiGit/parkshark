package com.switchfully.parkshark.division.domain.dto;

public class CreateDivisionDto {
   private String divisionName;
   private String originalName;
   private String director;

   private long parentId;

   public CreateDivisionDto(String divisionName, String originalName, String director, long parentId) {
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
      this.parentId = parentId;
   }

   public CreateDivisionDto(String divisionName, String originalName, String director) {
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
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
