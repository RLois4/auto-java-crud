package com.projeto0.model;

public class Coin {
   private float value;
   private String name;

// getters
   public float getValue() {
      return value;
   }
   public String getName() {
      return name;
   }

// setters
   public void setValue( float value ) {
       this.value = value;
   }
   public void setName( String name ) {
       this.name = name;
   }

   @Override
   public String toString() {
       return "value -> " + getValue() + "\n" + "name -> " + getName() + "\n" + "";
   }
}
