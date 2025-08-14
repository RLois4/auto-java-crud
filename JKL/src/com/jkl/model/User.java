package com.jkl.model;

public class User {
    private int id;
    private String name;
    private float value;

// getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getValue() {
        return value;
    }

// setters
    public void setId( int id ) {
        this.id = id;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void setValue( float value ) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "id -> " + getId() + "\n" + "name -> " + getName() + "\n" + "value -> " + getValue() + "\n" + "";
    }
}
