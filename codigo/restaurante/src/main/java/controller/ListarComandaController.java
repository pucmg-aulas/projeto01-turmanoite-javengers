package main.java.controller;

import main.java.model.Atendimento;
import main.java.view.ComandaView;

import javax.swing.table.DefaultTableModel;

public class ListarComandaController {
    private final ComandaView view;
    private final Atendimento atendimento;

    public ListarComandaController(Atendimento atendimento) {
        this.view = new ComandaView();
        this.atendimento = atendimento;

        carregaTabela();

        this.view.setTitle("Comanda do Cliente " + atendimento.getCliente().getNome());
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Quantidade", "Item", "Valor Unitário", "Quantidade", "Valor Total" }, 0);

        atendimento.getComanda().getPedidos().forEach(pedido -> model.addRow(new Object[] {
                pedido.getQuantidade(),
                pedido.getAlimento().getNome(),
                pedido.getAlimento().getValor(),
                pedido.getQuantidade(),
                pedido.getValorTotal()
        }));

        view.getTabelaPedidos().setModel(model);
    }
}
