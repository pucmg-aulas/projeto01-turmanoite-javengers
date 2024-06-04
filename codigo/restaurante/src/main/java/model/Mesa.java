package main.java.model;

import java.io.Serializable;

public class Mesa implements Serializable {

    private static int proxNumero;
    private int numero;
    private int quantCadeiras;
    private boolean ocupada;

    static{
        proxNumero = 1;
    }

    public Mesa(int quantCadeiras) {
        this.numero = proxNumero;
        this.quantCadeiras = quantCadeiras;
        this.ocupada = false;
        proxNumero++;
    }

    public int getNumero() {
        return numero;
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

    @Override
    public String toString() {
        return proxNumero + "%" + numero + "%" + quantCadeiras + "%" + ocupada;
    }
}