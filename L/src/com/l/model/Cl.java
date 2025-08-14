package com.l.model;

public class Cl {
    private int valor;
    private String name;
    private int id_teste;

// getters
    public int getValor() {
        return valor;
    }
    public String getName() {
        return name;
    }
    public int getId_teste() {
        return id_teste;
    }

// setters
    public void setValor( int valor ) {
        this.valor = valor;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void setId_teste( int id_teste ) {
        this.id_teste = id_teste;
    }

    @Override
    public String toString() {
        return "valor -> " + getValor() + "\n" + "name -> " + getName() + "\n" + "id_teste -> " + getId_teste() + "\n" + "";
    }
}
