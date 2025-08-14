package com.po.model;

public class Animal {
    private int age;
    private String raca;

// getters
    public int getAge() {
        return age;
    }
    public String getRaca() {
        return raca;
    }

// setters
    public void setAge( int age ) {
        this.age = age;
    }
    public void setRaca( String raca ) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "age -> " + getAge() + "\n" + "raca -> " + getRaca() + "\n" + "";
    }
}
