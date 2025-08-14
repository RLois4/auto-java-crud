package com.pro.model;

public class aModel {
   private i a;
   private a b;

// getters
   public i getA() {
      return a;
   }
   public a getB() {
      return b;
   }

// setters
   public void setA( i a ) {
       this.a = a;
   }
   public void setB( a b ) {
       this.b = b;
   }

   @Override
   public String toString() {
       return "a -> " + getA() + "\n" + "b -> " + getB() + "\n" + "";
   }
}
