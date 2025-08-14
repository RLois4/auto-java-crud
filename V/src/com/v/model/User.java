package com.v.model;

public class User {
    private int age;
    private String name;
    private String id;

// getters
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }

// setters
    public void setAge( int age ) {
        this.age = age;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void setId( String id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "age -> " + getAge() + "\n" + "name -> " + getName() + "\n" + "id -> " + getId() + "\n" + "";
    }
}
