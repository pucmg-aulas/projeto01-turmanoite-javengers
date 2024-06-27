package main.java.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String cpf;
    private String nome;

    public Cliente(String nome, String cpf) {
        this.cpf = String.format("%011d", Long.parseLong(cpf));
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + "%" + cpf;
    }
}