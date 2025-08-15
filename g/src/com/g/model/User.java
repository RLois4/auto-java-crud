package com.g.model;

public class User {
    private int code;

// getters
    public int getCode() {
        return code;
    }

// setters
    public void setCode( int code ) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "code -> " + getCode() + "\n" + "";
    }
}
