package com.projeto.model;

public class User {
    private int id;
    private String email;

// getters
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

// setters
    public void setId( int id ) {
        this.id = id;
    }
    public void setEmail( String email ) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id -> " + getId() + "\n" + "email -> " + getEmail() + "\n" + "";
    }
}
