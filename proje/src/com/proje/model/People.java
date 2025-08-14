package com.proje.model;

public class People {
    private int id;

// getters
    public int getId() {
        return id;
    }

// setters
    public void setId( int id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id -> " + getId() + "\n" + "";
    }
}
