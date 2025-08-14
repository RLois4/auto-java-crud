package com.o.model;

public class Teste Model {
   private String atr1;
   private int atr2;

// getters
   public String getAtr1() {
      return atr1;
   }
   public int getAtr2() {
      return atr2;
   }

// setters
   public void setAtr1( String atr1 ) {
       this.atr1 = atr1;
   }
   public void setAtr2( int atr2 ) {
       this.atr2 = atr2;
   }

   @Override
   public String toString() {
       return "atr1 -> " + getAtr1() + "\n" + "atr2 -> " + getAtr2() + "\n" + "";
   }
}
