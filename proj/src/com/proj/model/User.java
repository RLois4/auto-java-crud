package com.proj.model;

public class UserModel {
   private int id;
   private String name;

// getters
   public int getId() {
      return id;
   }
   public String getName() {
      return name;
   }

// setters
   public void setId( int id ) {
       this.id = id;
   }
   public void setName( String name ) {
       this.name = name;
   }

   @Override
   public String toString() {
       return "id -> " + getId() + "\n" + "name -> " + getName() + "\n" + "";
   }
}
