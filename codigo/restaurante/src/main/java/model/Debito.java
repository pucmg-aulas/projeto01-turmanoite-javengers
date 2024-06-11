package main.java.model;

public class Debito extends MetodoPagamento {
    public Debito() {
        super(14, 1.4); // Prazo 14 dias, desconto 1.4%, sem desconto máximo
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        return valorOriginal * (descontoPercentual / 100);
    }
}