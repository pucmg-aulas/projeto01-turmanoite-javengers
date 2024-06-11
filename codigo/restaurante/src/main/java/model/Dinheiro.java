package main.java.model;

public class Dinheiro extends MetodoPagamento {
    public Dinheiro() {
        super(0, 0); // Prazo 0, desconto 0%, desconto máximo 0
    }

    @Override
    public double calcularDesconto(double valorOriginal) {
        return 0; // Sem desconto para pagamento em dinheiro
    }
}