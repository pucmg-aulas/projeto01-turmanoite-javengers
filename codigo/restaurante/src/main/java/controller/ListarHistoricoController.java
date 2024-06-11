package main.java.controller;

import main.java.dao.Historico;
import main.java.view.HistoricoAtendimentoView;

import javax.swing.table.DefaultTableModel;

public class ListarHistoricoController {
    private final HistoricoAtendimentoView view;
    private final Historico historico;

    public ListarHistoricoController() {
        this.historico = Historico.getInstance();
        this.view = new HistoricoAtendimentoView();
        carregaTabela();
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "CPF", "Data" }, 0);

        historico.getAtendimentos().forEach(atendimento -> model.addRow(new Object[] {
                atendimento.getCliente().getNome(),
                atendimento.getCliente().getCpf(),
                atendimento.getData()
        }));

        view.getTabelaHistorico().setModel(model);
    }

    private void sair() {
        this.view.dispose();
    }
}
