package com.po.model;

public class User {
    private int id;
    private String name;
    private float grana;

// getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getGrana() {
        return grana;
    }

// setters
    public void setId( int id ) {
        this.id = id;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void setGrana( float grana ) {
        this.grana = grana;
    }

    @Override
    public String toString() {
        return "id -> " + getId() + "\n" + "name -> " + getName() + "\n" + "grana -> " + getGrana() + "\n" + "";
    }
}
