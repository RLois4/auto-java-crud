package com.test.model;

public class User {
    private String name;

// getters
    public String getName() {
        return name;
    }

// setters
    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name -> " + getName() + "\n" + "";
    }
}
