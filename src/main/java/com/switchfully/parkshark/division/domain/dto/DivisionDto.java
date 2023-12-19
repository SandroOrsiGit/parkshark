package com.switchfully.parkshark.division.domain.dto;

public class DivisionDto {
   
   private String divisionName;
   
   private String originalName;
   
   private String director;

   private Long parentId;
   
   public DivisionDto() {
   }

   public DivisionDto(String divisionName, String originalName, String director, Long parentId) {
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

   public Long getParentId() {
      return parentId;
   }

   @Override
   public String toString() {
      return "DivisionDto{" +
              "divisionName='" + divisionName + '\'' +
              ", originalName='" + originalName + '\'' +
              ", director='" + director + '\'' +
              ", parentId=" + parentId +
              '}';
   }
}
