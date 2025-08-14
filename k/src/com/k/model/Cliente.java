package com.k.model;

public class Cliente {
    private String nome;
    private String email;
    private float pk;

// getters
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public float getPk() {
        return pk;
    }

// setters
    public void setNome( String nome ) {
        this.nome = nome;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public void setPk( float pk ) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "nome -> " + getNome() + "\n" + "email -> " + getEmail() + "\n" + "pk -> " + getPk() + "\n" + "";
    }
}
