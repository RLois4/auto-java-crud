package com.proje.model;

public class Animal {
    private int age;

// getters
    public int getAge() {
        return age;
    }

// setters
    public void setAge( int age ) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age -> " + getAge() + "\n" + "";
    }
}
