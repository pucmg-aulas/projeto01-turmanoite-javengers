package main.java.model;

import java.io.Serializable;

public class Mesa implements Serializable {

    private int quantCadeiras;
    private boolean ocupada;

    public Mesa(int quantCadeiras) {
        this.quantCadeiras = quantCadeiras;
        this.ocupada = false;
    }

    public int getQuantCadeiras() {
        return quantCadeiras;
    }

    public boolean isOcupada() { // retorna o status da mesa
        return ocupada;
    }

    public void setOcupada(boolean ocupada) { // mudar o status da mesa quando um cliente ocupa/libera
        this.ocupada = ocupada;
    }
}