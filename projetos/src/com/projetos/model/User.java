package com.projetos.model;

public class User {
    private String name;
    private int idade;
    private String email;
    private float a_pagar;

// getters
    public String getName() {
        return name;
    }
    public int getIdade() {
        return idade;
    }
    public String getEmail() {
        return email;
    }
    public float getA_pagar() {
        return a_pagar;
    }

// setters
    public void setName( String name ) {
        this.name = name;
    }
    public void setIdade( int idade ) {
        this.idade = idade;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public void setA_pagar( float a_pagar ) {
        this.a_pagar = a_pagar;
    }

    @Override
    public String toString() {
        return "name -> " + getName() + "\n" + "idade -> " + getIdade() + "\n" + "email -> " + getEmail() + "\n" + "a_pagar -> " + getA_pagar() + "\n" + "";
    }
}
