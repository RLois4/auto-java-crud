package com.newproject.model;

public class Users {
   private String name;
   private int id;

// getters
   public String getName() {
      return name;
   }
   public int getId() {
      return id;
   }

// setters
   public void setName( String name ) {
       this.name = name;
   }
   public void setId( int id ) {
       this.id = id;
   }

   @Override
   public String toString() {
       return "name -> " + getName() + "\n" + "id -> " + getId() + "\n" + "";
   }
}
