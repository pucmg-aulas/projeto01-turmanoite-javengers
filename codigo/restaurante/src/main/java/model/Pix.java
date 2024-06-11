package main.java.model;

public class Pix extends MetodoPagamento {
    public Pix() {
        super(0, 1.45); // Prazo 0, desconto 1.45%, máximo R$10
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        double desconto = valorOriginal * (descontoPercentual / 100);
        return Math.min(desconto, 10); 
    }
}