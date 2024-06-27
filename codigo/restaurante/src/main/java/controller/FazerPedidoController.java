package main.java.controller;

import main.java.dao.Alimentos;
import main.java.dao.Atendimentos;
import main.java.model.Alimento;
import main.java.model.Atendimento;
import main.java.model.Pedido;
import main.java.view.FazerPedidoView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

            int selectedRow = view.getCardapioTable().getSelectedRow();

            if (selectedRow >= 0) {
                String nomeAlimento = (String) view.getCardapioTable().getValueAt(selectedRow, 0);

                Alimento alimento = alimentos.buscarAlimentoPorNome(nomeAlimento);
                if (alimento != null) {
                    Pedido pedido = new Pedido(alimento, quantidade);
                    atendimento.getComanda().addPedidos(pedido);
                    atendimentos.altera(atendimento, atendimento.getCliente().getCpf());
                    JOptionPane.showMessageDialog(view, "Pedido salvo com sucesso!");

                    this.view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Alimento não encontrado.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Selecione um alimento.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Quantidade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaComboBox() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "Descrição", "Valor" }, 0);

        alimentos.getAlimentos().stream().forEach(alimento -> {
            model.addRow(new Object[] { alimento.getNome(), alimento.getDescricao(), "R$" + alimento.getValor() });
        });

        view.getCardapioTable().setModel(model);
    }
}
