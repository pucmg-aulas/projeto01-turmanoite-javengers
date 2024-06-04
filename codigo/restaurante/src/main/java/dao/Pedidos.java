package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Pedido;

public class Pedidos extends AbstractDao implements Serializable {

    private List<Pedido> pedidos;
    private static Pedidos instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Pedidos.dat";

    private Pedidos() {
        this.pedidos = new ArrayList<>();
        carregaPedidos();
    }

    public static Pedidos getInstance() {
        if (instance == null) {
            instance = new Pedidos();
        }
        return instance;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        grava();
    }

    private void carregaPedidos() {
        this.pedidos = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, pedidos);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void excluirPedido(Pedido pedido) {
        pedidos.remove(pedido);
        grava();
    }
}
