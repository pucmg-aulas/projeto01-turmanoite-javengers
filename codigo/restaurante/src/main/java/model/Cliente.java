package main.java.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String cpf;

    private String nome;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}