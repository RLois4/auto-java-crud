package com.u.model;

public class UserModel {
   private int a;
   private String b;

// getters
   public int getA() {
      return a;
   }
   public String getB() {
      return b;
   }

// setters
   public void setA( int a ) {
       this.a = a;
   }
   public void setB( String b ) {
       this.b = b;
   }

   @Override
   public String toString() {
       return "a -> " + getA() + "\n" + "b -> " + getB() + "\n" + "";
   }
}
