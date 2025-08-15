package com.projetot.model;

public class Usuario {
    private String name;
    private String email;
    private String cpf;
    private float dinheiro;
    private int codigo;

// getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getCpf() {
        return cpf;
    }
    public float getDinheiro() {
        return dinheiro;
    }
    public int getCodigo() {
        return codigo;
    }

// setters
    public void setName( String name ) {
        this.name = name;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public void setCpf( String cpf ) {
        this.cpf = cpf;
    }
    public void setDinheiro( float dinheiro ) {
        this.dinheiro = dinheiro;
    }
    public void setCodigo( int codigo ) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "name -> " + getName() + "\n" + "email -> " + getEmail() + "\n" + "cpf -> " + getCpf() + "\n" + "dinheiro -> " + getDinheiro() + "\n" + "codigo -> " + getCodigo() + "\n" + "";
    }
}
