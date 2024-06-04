package main.java.controller;

import java.util.Iterator;

import javax.swing.JOptionPane;

import main.java.dao.Alimentos;
import main.java.dao.Pedidos;
import main.java.model.Alimento;
import main.java.model.Atendimento;
import main.java.model.Pedido;
import main.java.view.FazerPedidoView;

public class FazerPedidoController {
    private FazerPedidoView view;
    private Pedidos pedidos;
    private Alimentos alimentos;

    public FazerPedidoController(Atendimento atendimento) {
        this.pedidos = Pedidos.getInstance();
        this.alimentos = Alimentos.getInstance();
        this.view = new FazerPedidoView();

        this.view.getSalvarPedidoButton().addActionListener((e) -> {
            addPedido(atendimento);
        });

        carregaComboBox();

        // this.view.getBtnCancelar().addActionListener((e) -> {
        // cancelar();
        // });

        this.view.setTitle("Fazer Pedido");
        this.view.setVisible(true);
    }

    public void addPedido(Atendimento atendimento) {
        int quantidade = Integer.parseInt(view.getQuantidadeTextField().getText());
        Alimento alimento = (Alimento) view.getItemComboBox().getSelectedItem();
        Pedido pedido = new Pedido(alimento, quantidade);
        atendimento.getComanda().addPedidos(pedido);
        pedidos.addPedido(pedido);
        JOptionPane.showMessageDialog(view, "Pedido salvo com sucesso!");
        limparTela();
    }

    @SuppressWarnings("unchecked")
    private void carregaComboBox() {
        Iterator<Alimento> it = alimentos.getCarros().iterator();
        while (it.hasNext()) {
            Alimento alimento = it.next();
            this.view.getItemComboBox().addItem(alimento);
        }
    }

    // private void cancelar() {
    //     this.view.dispose();
    // }

    private void limparTela() {
        this.view.getQuantidadeTextField().setText("");
    }
}