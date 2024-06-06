package main.java.controller;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

import main.java.model.Atendimento;
import main.java.model.Pedido;
import main.java.view.EncerrarAtendimentoView;

public class EncerrarAtendimentoController {

    private EncerrarAtendimentoView view;
    private Atendimento atendimento;

    public EncerrarAtendimentoController(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.view = new EncerrarAtendimentoView();

        carregaTela();

        this.view.setVisible(true);

    }

    private void carregaTela() {
        this.view.getTxtNomeCliente().setText(atendimento.getCliente().getNome());
        this.view.getNumQuantidadePessoas().setText(String.valueOf(atendimento.getQuantPessoas()));
        this.view.getNumValorTotal().setText(String.valueOf(atendimento.getComanda().calculaValor()));
        carregaComanda();
    }

    private void carregaComanda() {
        Object colunas[] = { "Quantidade", "Item", "Valor", "Quantidade", "Valor Total" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Pedido> it = atendimento.getComanda().getPedidos().iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            String pedido = p.toString();
            String linha[] = pedido.split("%");
            tm.addRow(new Object[] { linha[1], linha[2], linha[3], linha[4], linha[5] });
        }
        view.getTableContaCliete().setModel(tm);
    }
}