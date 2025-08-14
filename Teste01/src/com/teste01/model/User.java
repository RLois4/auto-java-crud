package com.teste01.model;

public class User {
    private int id;
    private float dinheiro;
    private String email;

// getters
    public int getId() {
        return id;
    }
    public float getDinheiro() {
        return dinheiro;
    }
    public String getEmail() {
        return email;
    }

// setters
    public void setId( int id ) {
        this.id = id;
    }
    public void setDinheiro( float dinheiro ) {
        this.dinheiro = dinheiro;
    }
    public void setEmail( String email ) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id -> " + getId() + "\n" + "dinheiro -> " + getDinheiro() + "\n" + "email -> " + getEmail() + "\n" + "";
    }
}
