package com.projetot.model;

public class Animal {
    private String raca;
    private String name;
    private int age;
    private String codigo_animal;

// getters
    public String getRaca() {
        return raca;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCodigo_animal() {
        return codigo_animal;
    }

// setters
    public void setRaca( String raca ) {
        this.raca = raca;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void setAge( int age ) {
        this.age = age;
    }
    public void setCodigo_animal( String codigo_animal ) {
        this.codigo_animal = codigo_animal;
    }

    @Override
    public String toString() {
        return "raca -> " + getRaca() + "\n" + "name -> " + getName() + "\n" + "age -> " + getAge() + "\n" + "codigo_animal -> " + getCodigo_animal() + "\n" + "";
    }
}
