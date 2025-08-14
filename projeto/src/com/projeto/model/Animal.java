package com.projeto.model;

public class Animal {
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
