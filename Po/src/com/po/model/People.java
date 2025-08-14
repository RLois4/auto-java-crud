package com.po.model;

public class People {
    private String cpf;

// getters
    public String getCpf() {
        return cpf;
    }

// setters
    public void setCpf( String cpf ) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "cpf -> " + getCpf() + "\n" + "";
    }
}
