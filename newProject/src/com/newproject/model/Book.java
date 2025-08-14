package com.newproject.model;

public class Book {
   private int pages;
   private String isbn;
   private String title;

// getters
   public int getPages() {
      return pages;
   }
   public String getIsbn() {
      return isbn;
   }
   public String getTitle() {
      return title;
   }

// setters
   public void setPages( int pages ) {
       this.pages = pages;
   }
   public void setIsbn( String isbn ) {
       this.isbn = isbn;
   }
   public void setTitle( String title ) {
       this.title = title;
   }

   @Override
   public String toString() {
       return "pages -> " + getPages() + "\n" + "isbn -> " + getIsbn() + "\n" + "title -> " + getTitle() + "\n" + "";
   }
}
