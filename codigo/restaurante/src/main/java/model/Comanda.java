package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Comanda implements Serializable {
    final static double TAXA = 10;
    private ArrayList<Pedido> pedidos;

    public Comanda() {
        this.pedidos = new ArrayList<>();
    }

    public Comanda(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public static double getTaxa() {
        return TAXA;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedidos(Pedido pedido) {
        this.pedidos.add(pedido);

    }

    @Override
    public String toString() {
        return "" + pedidos;
    }

    public double calculaValor() {
        double valor = 0;
        valor = pedidos.stream()
                .mapToDouble(Pedido::getValorTotal)
                .sum();
        valor += valor * TAXA / 100;
        return Math.round(valor * 100.0) / 100.0;
    }

}
