package com.switchfully.parkshark.division.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "DIVISION")
public class Division {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "division_id")
   private Long id;
   
   @Column(name = "division_name")
   private String divisionName;
   
   @Column(name = "original_division_name")
   private String originalName;
   
   @Column(name = "director")
   private String director;

   @Column(name = "parent_division_id")
   private Long parentId;


   public Division() {
   }

   public Division(String divisionName, String originalName, String director, Long parentId) {
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
      this.parentId = parentId;
   }
   
   public Division(String divisionName, String originalName, String director) {
      this.divisionName = divisionName;
      this.originalName = originalName;
      this.director = director;
   }
   
   public Long getId() {
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

   public Long getParentId() {
      return parentId;
   }

   @Override
   public String toString() {
      return "Division{" + "id=" + id + ", divisionName='" + divisionName + '\'' + ", originalName='" + originalName + '\'' + ", director='" + director + '\'' + '}';
   }
   
   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Division division = (Division) o;
      return id == division.id;
   }
   
   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
