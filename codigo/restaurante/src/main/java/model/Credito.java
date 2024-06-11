package main.java.model;

public class Credito extends MetodoPagamento {
    public Credito() {
        super(30, 3.1); // Prazo 30 dias, desconto 3.1%, sem desconto máximo
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        return valorOriginal * (descontoPercentual / 100);
    }
}