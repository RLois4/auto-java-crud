package com.projeto0.model;

public class MinhaClasse {
   private int id;
   private String name;
   private float real;

// getters
   public int getId() {
      return id;
   }
   public String getName() {
      return name;
   }
   public float getReal() {
      return real;
   }

// setters
   public void setId( int id ) {
       this.id = id;
   }
   public void setName( String name ) {
       this.name = name;
   }
   public void setReal( float real ) {
       this.real = real;
   }

   @Override
   public String toString() {
       return "id -> " + getId() + "\n" + "name -> " + getName() + "\n" + "real -> " + getReal() + "\n" + "";
   }
}
