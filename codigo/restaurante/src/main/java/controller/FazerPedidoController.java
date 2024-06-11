package main.java.controller;

import main.java.dao.Alimentos;
import main.java.dao.Atendimentos;
import main.java.model.Alimento;
import main.java.model.Atendimento;
import main.java.model.Pedido;
import main.java.view.FazerPedidoView;
import javax.swing.*;
import java.util.List;

public class FazerPedidoController {
    private final FazerPedidoView view;
    private final Alimentos alimentos;
    private final Atendimentos atendimentos;
    private final Atendimento atendimento;

    public FazerPedidoController(Atendimento atendimento) {
        this.view = new FazerPedidoView();
        this.atendimento = atendimento;
        this.atendimentos = Atendimentos.getInstance();
        this.alimentos = Alimentos.getInstance();

        this.view.getSalvarPedidoButton().addActionListener(e -> addPedido());
        carregaComboBox();

        this.view.setTitle("Fazer Pedido");
        this.view.setVisible(true);
    }

    private void addPedido() {
        try {
            int quantidade = Integer.parseInt(view.getQuantidadeTextField().getText());
            if (quantidade <= 0) {
                throw new NumberFormatException("A quantidade deve ser maior que zero.");
            }

            String nomeAlimento = (String) view.getItemComboBox().getSelectedItem();
            Alimento alimento = alimentos.buscarAlimentoPorNome(nomeAlimento);
            if (alimento != null) {
                Pedido pedido = new Pedido(alimento, quantidade);
                atendimento.getComanda().addPedidos(pedido);
                atendimentos.altera(atendimento, atendimento.getCliente().getCpf());
                JOptionPane.showMessageDialog(view, "Pedido salvo com sucesso!");
                limparTela();
            } else {
                JOptionPane.showMessageDialog(view, "Alimento não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Quantidade inválida: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaComboBox() {
        List<Alimento> alimentosList = alimentos.getAlimentos();
        for (Alimento alimento : alimentosList) {
            this.view.getItemComboBox().addItem(alimento.getNome());
        }
    }

    private void limparTela() {
        this.view.getQuantidadeTextField().setText("");
    }
}
