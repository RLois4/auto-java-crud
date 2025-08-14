package com.user: string name, int age, int code.model;

public class User {
    private String name;
    private int age;
    private int code;

// getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getCode() {
        return code;
    }

// setters
    public void setName( String name ) {
        this.name = name;
    }
    public void setAge( int age ) {
        this.age = age;
    }
    public void setCode( int code ) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "name -> " + getName() + "\n" + "age -> " + getAge() + "\n" + "code -> " + getCode() + "\n" + "";
    }
}
