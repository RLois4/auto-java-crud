package com.projetot.model;

public class Livro {
    private String title;
    private String isbn;

// getters
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }

// setters
    public void setTitle( String title ) {
        this.title = title;
    }
    public void setIsbn( String isbn ) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "title -> " + getTitle() + "\n" + "isbn -> " + getIsbn() + "\n" + "";
    }
}
