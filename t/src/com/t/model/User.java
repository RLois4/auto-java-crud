package com.t.model;

public class User {
    private String name;
    private int cd;

// getters
    public String getName() {
        return name;
    }
    public int getCd() {
        return cd;
    }

// setters
    public void setName( String name ) {
        this.name = name;
    }
    public void setCd( int cd ) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return "name -> " + getName() + "\n" + "cd -> " + getCd() + "\n" + "";
    }
}
