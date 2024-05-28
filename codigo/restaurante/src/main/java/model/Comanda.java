package main.java.model;

import java.util.ArrayList;

public class Comanda {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    final static double TAXA = 10;

    public void adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public double calculaValor() {
        double valor = 0;
        for (Pedido pedido : pedidos) {
            valor += pedido.getValorTotal();
        }
        valor += valor * TAXA / 100;
        return Math.round(valor * 100.0) / 100.0; // Truncando valores monetários para 2 casas decimais
    }

    public void imprimeComanda() {
        System.out.println("\nComanda:\n");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
        System.out.println("\nValor total com taxa: R$" + calculaValor());
    }
}
