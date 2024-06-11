package main.java.model;

public abstract class MetodoPagamento {
    protected int prazoDias;
    protected double descontoPercentual;

    public MetodoPagamento(int prazoDias, double descontoPercentual) {
        this.prazoDias = prazoDias;
        this.descontoPercentual = descontoPercentual;
    }

    public abstract double calcularDesconto(double valorOriginal);
}